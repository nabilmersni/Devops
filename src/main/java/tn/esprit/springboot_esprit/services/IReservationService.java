package tn.esprit.springboot_esprit.services;

import tn.esprit.springboot_esprit.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {

    Reservation add(Reservation reservation);
    Reservation getOne(String idReservation);
    List<Reservation> getAll();
    Reservation update(Reservation reservation);
    void delete(String idReservation);
    public Reservation ajouterReservation (long idChambre, long cinEtudiant) ;
    public Reservation annulerReservation (long cinEtudiant);
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) ;


//    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (Reservation res, Long numChambre, long cin);
//    List<Reservation> getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee );

}
