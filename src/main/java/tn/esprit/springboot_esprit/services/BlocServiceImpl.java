package tn.esprit.springboot_esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springboot_esprit.entities.Bloc;
import tn.esprit.springboot_esprit.entities.Chambre;
import tn.esprit.springboot_esprit.entities.Foyer;
import tn.esprit.springboot_esprit.repositories.BlocRepository;
import tn.esprit.springboot_esprit.repositories.ChambreRepository;
import tn.esprit.springboot_esprit.repositories.FoyerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService{

    BlocRepository blocRepository;
    ChambreRepository chambreRepository;
    FoyerRepository foyerRepository;


    @Override
    public Bloc add(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc getOne(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public List<Bloc> getAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc update(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void delete(long idBloc) {
        blocRepository.deleteById(idBloc);
    }


    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        if(bloc == null){
            throw new RuntimeException("Bloc not found");
        }

        for (Long numCham: numChambre) {
            Chambre chambre = chambreRepository.findById(numCham).orElse(null);
            if(chambre == null){
                throw new RuntimeException("Chambre not found");
            }
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
        }
        return null;
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);
        Foyer foyer = foyerRepository.findByNomFoyer(nomFoyer);
        bloc.setFoyer(foyer);
        return blocRepository.save(bloc);
    }
}
