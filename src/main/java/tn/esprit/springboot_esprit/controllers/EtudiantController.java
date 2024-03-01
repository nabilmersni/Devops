package tn.esprit.springboot_esprit.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot_esprit.entities.Etudiant;
import tn.esprit.springboot_esprit.services.EtudiantServiceImpl;
import tn.esprit.springboot_esprit.services.IEtudiantService;

import java.util.List;

@RestController
public class EtudiantController {


    IEtudiantService etudiantService;

    EtudiantController(EtudiantServiceImpl etudiantService){
        this.etudiantService = etudiantService;
    }


    @GetMapping("/etudiant")
    List<Etudiant> getAllEtudiant(){
        return  etudiantService.getAll();
    }

    @GetMapping("/etudiant/{etudiantId}")
    Etudiant getOneEtudiant(@PathVariable long etudiantId){
        return  etudiantService.getOne(etudiantId);
    }

    @PostMapping("/etudiant")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.add(etudiant);
    }

    @PutMapping("/etudiant")
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.update(etudiant);
    }

    @DeleteMapping("/etudiant/{etudiantId}")
    void deleteEtudiant(@PathVariable long etudiantId){
        etudiantService.delete(etudiantId);
    }
}
