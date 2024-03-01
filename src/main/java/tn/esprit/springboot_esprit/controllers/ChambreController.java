package tn.esprit.springboot_esprit.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot_esprit.entities.Chambre;
import tn.esprit.springboot_esprit.entities.TypeChambre;
import tn.esprit.springboot_esprit.services.ChambreServiceImpl;
import tn.esprit.springboot_esprit.services.IChambreService;

import java.util.List;

@RestController
public class ChambreController {

    IChambreService chambreService;

    ChambreController(ChambreServiceImpl chambreService){
        this.chambreService = chambreService;
    }


    @GetMapping("/chambre")
    List<Chambre> getAllChambre(){
        return  chambreService.getAll();
    }

    @GetMapping("/chambre/{chambreId}")
    Chambre getOneChambre(@PathVariable long chambreId){
        return  chambreService.getOne(chambreId);
    }

    @PostMapping("/chambre")
    Chambre addChambre(@RequestBody Chambre chambre){
        return chambreService.add(chambre);
    }

    @PutMapping("/chambre")
    Chambre updateChambre(@RequestBody Chambre chambre){
        return chambreService.update(chambre);
    }

    @DeleteMapping("/chambre/{chambreId}")
    void deleteChambre(@PathVariable long chambreId){
        chambreService.delete(chambreId);
    }

    @GetMapping("/chambreByUni/{nomUniversite}")
    List<Chambre> getChambresParNomUniversite(@PathVariable String nomUniversite){
        return chambreService.getChambresParNomUniversite(nomUniversite);
    }

    @GetMapping("/chambreByblocAndType/{idBloc}/{typeChambre}")
    List<Chambre> getChambresParBlocEtType(@PathVariable long idBloc,@PathVariable TypeChambre typeChambre){
        return chambreService.getChambresParBlocEtType(idBloc,typeChambre);
    }
}
