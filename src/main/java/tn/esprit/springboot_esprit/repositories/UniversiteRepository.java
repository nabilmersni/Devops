package tn.esprit.springboot_esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springboot_esprit.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {

    @Query("select u from Universite u where u.nomUniversite =: name")
    Universite getByName(@Param("name") String uniName);
    Universite findByNomUniversite(String nomUni);
}
