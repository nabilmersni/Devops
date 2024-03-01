package tn.esprit.springboot_esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springboot_esprit.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String> {

    @Query("select r from Reservation r where r.anneeUniversitaire between :startDate and :endDate")
    List<Reservation> getResevationsBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select r from Reservation r join Chambre c on r member of c.reservations where r.anneeUniversitaire =: anneeUniversite AND c.bloc.foyer.universite.nomUniversite =: nomUniversite")
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(@Param("anneeUniversite") Date anneeUniversite,@Param("nomUniversite") String nomUniversite) ;
}
