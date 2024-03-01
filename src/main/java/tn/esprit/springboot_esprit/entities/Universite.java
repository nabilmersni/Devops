package tn.esprit.springboot_esprit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUniversite;
    @Column(unique = true)
    String nomUniversite;
    String adresse;

    @OneToOne
    Foyer foyer;
}
