package tn.esprit.springboot_esprit.services;

import org.springframework.stereotype.Service;
import tn.esprit.springboot_esprit.entities.Etudiant;
import tn.esprit.springboot_esprit.repositories.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantServiceImpl implements IEtudiantService{

    EtudiantRepository etudiantRepository;

    EtudiantServiceImpl(EtudiantRepository etudiantRepository){
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant add(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant getOne(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void delete(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
