package tn.esprit.springboot_esprit.services;

import tn.esprit.springboot_esprit.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    Etudiant add(Etudiant etudiant);
    Etudiant getOne(long idEtudiant);
    List<Etudiant> getAll();
    Etudiant update(Etudiant etudiant);
    void delete(long idEtudiant);
}
