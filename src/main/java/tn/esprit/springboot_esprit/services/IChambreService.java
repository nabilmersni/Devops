package tn.esprit.springboot_esprit.services;

import tn.esprit.springboot_esprit.entities.Chambre;
import tn.esprit.springboot_esprit.entities.TypeChambre;

import java.util.List;

public interface IChambreService {

    Chambre add(Chambre chambre);
    Chambre getOne(long idChambre);
    List<Chambre> getAll();
    Chambre update(Chambre chambre);
    void delete(long idChambre);

    public List<Chambre> getChambresParNomUniversite( String nomUniversite);
    public List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre typeC);
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite,TypeChambre type);
}
