package tn.esprit.springboot_esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springboot_esprit.entities.Bloc;

public interface BlocRepository extends JpaRepository<Bloc,Long> {

    @Query("select b from Bloc b where b.nomBloc =: blocName")
    Bloc getByName(@Param("blocName") String blocName);

    Bloc findByNomBloc(String blocName);
}
