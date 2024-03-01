package tn.esprit.springboot_esprit.services;

import tn.esprit.springboot_esprit.entities.Bloc;

import java.util.List;

public interface IBlocService {

    Bloc add(Bloc bloc);
    Bloc getOne(long idBloc);
    List<Bloc> getAll();
    Bloc update(Bloc bloc);
    void delete(long idBloc);

//     Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;
     Bloc affecterBlocAFoyer( String nomBloc, String nomFoyer);
}
