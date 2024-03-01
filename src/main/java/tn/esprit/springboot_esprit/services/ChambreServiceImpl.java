package tn.esprit.springboot_esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springboot_esprit.entities.Bloc;
import tn.esprit.springboot_esprit.entities.Chambre;
import tn.esprit.springboot_esprit.entities.TypeChambre;
import tn.esprit.springboot_esprit.repositories.BlocRepository;
import tn.esprit.springboot_esprit.repositories.ChambreRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {

    ChambreRepository chambreRepository;
    BlocRepository blocRepository;

    @Override
    public Chambre add(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre getOne(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre update(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void delete(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepository.findByBlocFoyerUniversiteNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBlocIdBlocAndAndTypeChambre(idBloc,typeC);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return chambreRepository.getChambresNonReserveParNomUniversiteEtTypeChambree(nomUniversite,type);
    }


    @Scheduled(cron = "*/5 * * * * *")
    public void getChambresNonReserve() {
        List<Chambre> chambres = chambreRepository.getChambresNonReserve();
        for (Chambre ch : chambres){
            System.out.println(ch);
        }
    }

}
