package tn.esprit.foyerzouaouimaissa.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Chambre;
import tn.esprit.foyerzouaouimaissa.DAO.Model.TypeChambre;
import tn.esprit.foyerzouaouimaissa.Services.IBlocService;
import tn.esprit.foyerzouaouimaissa.Services.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ChambreRestController {
    IChambreService iChambreService;


    @GetMapping("findAllC")
    List<Chambre> findAllC(){
        return iChambreService.findAll();
    }

    @PostMapping("/addChambre")
    Chambre addChambre(@RequestBody Chambre c){
        return iChambreService.addChambre(c);
    }

    @DeleteMapping("/deleteChambre")
    public void delete(@RequestBody Chambre c) {
        iChambreService.delete(c);
    }

    @DeleteMapping("/deleteByIdC/{id}")
    public void deleteById(@PathVariable Long id) {
        iChambreService.deleteByIdC(id);
    }

    @PutMapping("/editChambre")
    public Chambre editChambre(@RequestBody Chambre c) {
        return iChambreService.editChambre(c);
    }
    @GetMapping("/findByNumeroChambre")

    public Chambre findByNumeroChambre(@RequestParam long numeroChambre) {
        return iChambreService.findByNumeroChambre(numeroChambre);
    }

    @GetMapping("getChamberList/{nomBloc}")
    List<Chambre> getChambresParNomBloc(@PathVariable("nomBloc") String nomBloc){
        return iChambreService.getChambresParNomBloc(nomBloc);
    }
    @GetMapping("chamberListNonReserver/{type}/{nomFoyer}")
    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(@PathVariable("type") TypeChambre type , String nomFoyer)
    {
        return iChambreService.getChambresNonReserveParNomFoyerEtTypeChambre(nomFoyer , type);
    }

    @GetMapping("nbChambreParTypeEtBloc/{type}/{idBloc}")
    long nbChambreParTypeEtBloc(@PathVariable("type") TypeChambre type , @PathVariable("idBloc") long idBloc){
        return iChambreService.nbChambreParTypeEtBloc(type , idBloc);
    }

}
    