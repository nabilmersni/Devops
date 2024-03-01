package tn.esprit.springboot_esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springboot_esprit.entities.Chambre;
import tn.esprit.springboot_esprit.entities.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByBlocFoyerUniversiteNomUniversite(String nomUni);


    @Query("select ch from Chambre ch where ch.bloc.idBloc =: idBloc AND ch.typeChambre =: typeC")
    List<Chambre> getChambreByBlocIdBlocAndAndTypeChambre(@Param("idBloc") long idBloc,@Param("typeC") TypeChambre typeChambre);
    List<Chambre> findByBlocIdBlocAndAndTypeChambre(long blocId, TypeChambre typeChambre);

    @Query("select ch from Chambre ch where ch.reservations is empty and ch.typeChambre =:type and ch.bloc.foyer.universite.nomUniversite =:nomUniversite")
    List<Chambre>getChambresNonReserveParNomUniversiteEtTypeChambree(@Param("nomUniversite") String nomUniversite,@Param("type") TypeChambre type) ;

    @Query("select ch from Chambre ch where ch.reservations is empty")
    List<Chambre>getChambresNonReserve() ;
}
