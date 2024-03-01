package tn.esprit.springboot_esprit.services;

import tn.esprit.springboot_esprit.entities.Foyer;

import java.util.List;

public interface IFoyerService {

    Foyer add(Foyer foyer);
    Foyer getOne(long idFoyer);
    List<Foyer> getAll();
    Foyer update(Foyer foyer);
    void delete(long idFoyer);

    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
