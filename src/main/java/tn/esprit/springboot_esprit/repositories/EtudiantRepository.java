package tn.esprit.springboot_esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springboot_esprit.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    Etudiant findByCin(Long cin);
}
