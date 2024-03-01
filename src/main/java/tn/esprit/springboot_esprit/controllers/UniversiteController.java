package tn.esprit.springboot_esprit.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot_esprit.entities.Universite;
import tn.esprit.springboot_esprit.services.IUniversiteService;
import tn.esprit.springboot_esprit.services.UniversiteServiceImpl;

import java.util.List;

@RestController
public class UniversiteController {

    IUniversiteService universiteService;

    UniversiteController(UniversiteServiceImpl universiteService){
        this.universiteService = universiteService;
    }

    @GetMapping("/universite")
    List<Universite> getAllUniversite(){
        return  universiteService.getAll();
    }

    @GetMapping("/universite/{universiteId}")
    Universite getOneUniversite(@PathVariable long universiteId){
        return  universiteService.getOne(universiteId);
    }

    @PostMapping("/universite")
    Universite addUniversite(@RequestBody Universite universite){
        return universiteService.add(universite);
    }

    @PutMapping("/universite")
    Universite updateUniversite(@RequestBody Universite universite){
        return universiteService.update(universite);
    }

    @DeleteMapping("/universite/{universiteId}")
    void deleteUniversite(@PathVariable long universiteId){
        universiteService.delete(universiteId);
    }

    @PutMapping("/universite/{foyerId}/{universiteId}")
    Universite affecterFoyerAUniversite(@PathVariable long foyerId,@PathVariable long universiteId){
        return universiteService.affecterFoyerAUniversite(foyerId,universiteId);
    }

    @PutMapping("/universite/{foyerId}/{universiteNom}")
    Universite affecterFoyerAUniversite(@PathVariable long foyerId,@PathVariable String universiteNom){
        return universiteService.affecterFoyerAUniversite(foyerId,universiteNom);
    }

    @PutMapping("/universite/{universiteId}")
    Universite desaffecterFoyerAUniversite(@PathVariable long universiteId){
        return universiteService.desaffecterFoyerAUniversite(universiteId);
    }

}
