package tn.esprit.springboot_esprit.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springboot_esprit.entities.Bloc;
import tn.esprit.springboot_esprit.entities.Foyer;
import tn.esprit.springboot_esprit.entities.Universite;
import tn.esprit.springboot_esprit.repositories.BlocRepository;
import tn.esprit.springboot_esprit.repositories.FoyerRepository;
import tn.esprit.springboot_esprit.repositories.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class FoyerServiceImpl implements IFoyerService{

    FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;
    BlocRepository blocRepository;


    @Override
    public Foyer add(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer getOne(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public List<Foyer> getAll() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer update(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void delete(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        if(universite == null){
            throw new RuntimeException("Universite not found");
        }

        for (Bloc bloc: foyer.getBlocs()){
            bloc.setFoyer(foyer);
            blocRepository.save(bloc);
        }
        universite.setFoyer(foyer);
        universiteRepository.save(universite);

        return foyerRepository.save(foyer);
    }
}
