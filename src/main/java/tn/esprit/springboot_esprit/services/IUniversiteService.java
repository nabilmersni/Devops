package tn.esprit.springboot_esprit.services;

import tn.esprit.springboot_esprit.entities.Universite;

import java.util.List;

public interface IUniversiteService {

    Universite add(Universite universite);
    Universite getOne(long idUniversite);
    List<Universite> getAll();
    Universite update(Universite universite);
    void delete(long idUniversite);

    Universite affecterFoyerAUniversite(long foyerId, long universiteId);
    Universite affecterFoyerAUniversite(long foyerId, String universiteNom);

    public Universite desaffecterFoyerAUniversite (long idUniversite) ;
}
