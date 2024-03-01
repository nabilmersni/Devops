package tn.esprit.springboot_esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springboot_esprit.entities.Foyer;
import tn.esprit.springboot_esprit.entities.Universite;
import tn.esprit.springboot_esprit.repositories.FoyerRepository;
import tn.esprit.springboot_esprit.repositories.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{

    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    @Override
    public Universite add(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite getOne(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public List<Universite> getAll() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite update(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void delete(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long foyerId, long universiteId) {
        Universite universite = universiteRepository.findById(universiteId).orElse(null);
        if(universite == null ){
            throw new RuntimeException("University not found");
        }

        Foyer foyer = foyerRepository.findById(foyerId).orElse(null);
        if(foyer == null ){
            throw new RuntimeException("Foyer not found");
        }

        universite.setFoyer(foyer);
        return universiteRepository.save(universite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long foyerId, String universiteNom) {
        Universite universite = universiteRepository.getByName(universiteNom);
        if(universite == null ){
            throw new RuntimeException("University not found");
        }

        Foyer foyer = foyerRepository.findById(foyerId).orElse(null);
        if(foyer == null ){
            throw new RuntimeException("Foyer not found");
        }

        universite.setFoyer(foyer);
        return universiteRepository.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        if(universite == null){
            throw new RuntimeException("University not found");
        }
        universite.setFoyer(null);
        return universiteRepository.save(universite);
    }
}
