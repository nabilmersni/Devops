package tn.esprit.springboot_esprit.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot_esprit.entities.Reservation;
import tn.esprit.springboot_esprit.services.IReservationService;
import tn.esprit.springboot_esprit.services.ReservationServiceImpl;

import java.util.Date;
import java.util.List;

@RestController
public class ReservationController {

    IReservationService reservationService;

    ReservationController(ReservationServiceImpl reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation")
    List<Reservation> getAllReservation(){
        return  reservationService.getAll();
    }

    @GetMapping("/reservation/{reservationId}")
    Reservation getOneReservation(@PathVariable String reservationId){
        return  reservationService.getOne(reservationId);
    }

    @PostMapping("/reservation")
    Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.add(reservation);
    }

    @PutMapping("/reservation")
    Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    @DeleteMapping("/reservation/{reservationId}")
    void deleteReservation(@PathVariable String reservationId){
        reservationService.delete(reservationId);
    }

    @PostMapping("/reservation/{idChambre}/{cinEtudiant}")
    Reservation ajouterReservation(@PathVariable long idChambre,@PathVariable long cinEtudiant){
        return reservationService.ajouterReservation(idChambre,cinEtudiant);
    }
    @GetMapping("/reservationByAnnANDUniNom/{anneeUniversite}/{nomUniversite}")
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(@PathVariable Date anneeUniversite,@PathVariable String nomUniversite){
        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite,nomUniversite);
    }

//    @GetMapping("/reservation/{debutAnnee}/{finAnnee}")
//    List<Reservation> getReservationParAnneeUniversitaire(@PathVariable Date debutAnnee, @PathVariable Date finAnnee){
//        return reservationService.getReservationParAnneeUniversitaire(debutAnnee,finAnnee);
//    }
}
