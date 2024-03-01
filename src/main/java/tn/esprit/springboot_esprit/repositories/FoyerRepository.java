package tn.esprit.springboot_esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springboot_esprit.entities.Foyer;

public interface FoyerRepository extends JpaRepository<Foyer,Long> {

    @Query("select f from Foyer f where f.nomFoyer =: nomFoyer")
    Foyer getByName(@Param("nomFoyer") String nomFoyer);

    Foyer findByNomFoyer(String nomFoyer);
}
