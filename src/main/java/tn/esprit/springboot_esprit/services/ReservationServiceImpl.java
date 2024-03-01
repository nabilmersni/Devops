package tn.esprit.springboot_esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springboot_esprit.entities.Chambre;
import tn.esprit.springboot_esprit.entities.Etudiant;
import tn.esprit.springboot_esprit.entities.Reservation;
import tn.esprit.springboot_esprit.entities.TypeChambre;
import tn.esprit.springboot_esprit.repositories.ChambreRepository;
import tn.esprit.springboot_esprit.repositories.EtudiantRepository;
import tn.esprit.springboot_esprit.repositories.ReservationRepository;

import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService{

    ReservationRepository reservationRepository;
    EtudiantRepository etudiantRepository;
    ChambreRepository chambreRepository;

    @Override
    public Reservation add(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getOne(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void delete(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if(etudiant == null){
            throw new RuntimeException("etudiant not found");
        }
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        if(chambre == null){
            throw new RuntimeException("chambre not found");
        }

        long reservedPlaceCount = chambre.getReservations().stream().filter(reservation -> reservation.getEstValide()).count();
        if(chambre.getTypeChambre().equals(TypeChambre.SIMPLE) && reservedPlaceCount >= 1){
            throw new RuntimeException("la capacité maximale de la chambre est atteinte");
        }else if(chambre.getTypeChambre().equals(TypeChambre.DOUBLE) && reservedPlaceCount >= 2){
            throw new RuntimeException("la capacité maximale de la chambre est atteinte");
        }else if(chambre.getTypeChambre().equals(TypeChambre.TRIPLE) && reservedPlaceCount >= 3){
            throw new RuntimeException("la capacité maximale de la chambre est atteinte");
        }

        Reservation reservation = new Reservation();
        reservation.setIdReservation(chambre.getNumeroChambre()+"-"+chambre.getBloc().getNomBloc()+"-"+ Year.now().getValue());
        reservation.setAnneeUniversitaire(new Date());
        reservation.setEstValide(true);

        etudiant.getReservations().add(reservation);
        chambre.getReservations().add(reservation);

        etudiantRepository.save(etudiant);
        chambreRepository.save(chambre);

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        //error fil énoncé
        return null;
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        return reservationRepository.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite,nomUniversite);
    }

}
