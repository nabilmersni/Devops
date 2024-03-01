package tn.esprit.springboot_esprit.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot_esprit.entities.Foyer;
import tn.esprit.springboot_esprit.services.FoyerServiceImpl;
import tn.esprit.springboot_esprit.services.IFoyerService;

import java.util.List;

@RestController
public class FoyerController {
    
    IFoyerService foyerService;

    FoyerController(FoyerServiceImpl foyerService){
        this.foyerService = foyerService;
    }

    @GetMapping("/foyer")
    List<Foyer> getAllFoyer(){
        return  foyerService.getAll();
    }

    @GetMapping("/foyer/{foyerId}")
    Foyer getOneFoyer(@PathVariable long foyerId){
        return  foyerService.getOne(foyerId);
    }

    @PostMapping("/foyer")
    Foyer addFoyer(@RequestBody Foyer foyer){
        return foyerService.add(foyer);
    }

    @PutMapping("/foyer")
    Foyer updateFoyer(@RequestBody Foyer foyer){
        return foyerService.update(foyer);
    }

    @DeleteMapping("/foyer/{foyerId}")
    void deleteFoyer(@PathVariable long foyerId){
        foyerService.delete(foyerId);
    }

    @PutMapping("/affFoyerUni/{idUniversite}")
    Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,@PathVariable long idUniversite){
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer,idUniversite);
    }
}
