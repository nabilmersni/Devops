package tn.esprit.springboot_esprit.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot_esprit.entities.Bloc;
import tn.esprit.springboot_esprit.services.BlocServiceImpl;
import tn.esprit.springboot_esprit.services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
public class BlocController {


    IBlocService blocService;

    @GetMapping("/bloc")
    List<Bloc> getAllBloc(){
        return  blocService.getAll();
    }

    @GetMapping("/bloc/{blocId}")
    Bloc getOneBloc(@PathVariable long blocId){
        return  blocService.getOne(blocId);
    }

    @PostMapping("/bloc")
    Bloc addBloc(@RequestBody Bloc bloc){
        return blocService.add(bloc);
    }

    @PutMapping("/bloc")
    Bloc updateBloc(@RequestBody Bloc bloc){
        return blocService.update(bloc);
    }

    @DeleteMapping("/bloc/{blocId}")
    void deleteBloc(@PathVariable long blocId){
          blocService.delete(blocId);
    }

    @PutMapping("/bloc/{idBloc}")
    Bloc affecterChambresABloc(@PathVariable long idBloc, @RequestBody List<Long> numChambre){
        return  blocService.affecterChambresABloc(numChambre,idBloc);
    }

    @PutMapping("/bloc/{nomBloc}/{nomFoyer}")
    Bloc affecterBlocAFoyer(@PathVariable String nomBloc,@PathVariable String nomFoyer){
        return  blocService.affecterBlocAFoyer(nomBloc,nomFoyer);
    }
}
