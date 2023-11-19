package tn.esprit.foyerzouaouimaissa.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Foyer;
import tn.esprit.foyerzouaouimaissa.Services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
public class BlocRestController {
    IBlocService iBlocService;


    @GetMapping("findAll")
    List<Bloc> findAll(){
        return iBlocService.findAll();
    }

    @PostMapping("/addBloc")
    Bloc addBloc(@RequestBody Bloc b){

        return iBlocService.addBloc(b);

    }

    @DeleteMapping("/deleteBloc")
    public void delete(@RequestBody Bloc b) {
        iBlocService.delete(b);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        iBlocService.deleteById(id);
    }

    @PutMapping("/editBloc")
    public Bloc editBloc(@RequestBody Bloc b) {
        return iBlocService.editBloc(b);
    }

    @GetMapping("findAllNom/{nomBloc}")
    public Bloc findAllNom(@PathVariable String nomBloc) {
        return iBlocService.findByNomBloc(nomBloc);
    }

    @GetMapping("findAllCap/{capaciteBloc}")
    public List<Bloc> findAllCap(@PathVariable Long capaciteBloc) {
        return iBlocService.findByCapaciteBloc(capaciteBloc);
    }

    @GetMapping("findByNomBlocAndCapaciteBloc")
    public List<Bloc> findByNomBlocAndCapaciteBloc(
            @RequestParam String nomBloc,
            @RequestParam long capaciteBloc
    ) {
        return iBlocService.findByNomBlocAndCapaciteBloc(nomBloc, capaciteBloc);
    }

    @GetMapping("/findByNomBlocIgnoreCase")
    public List<Bloc> findByNomBlocIgnoreCase(@RequestParam String nomBloc) {
        return iBlocService.findByNomBlocIgnoreCase(nomBloc);
    }

    @GetMapping("/findByCapaciteBlocGreaterThan")
    public List<Bloc> findByCapaciteBlocGreaterThan(@RequestParam long capacite) {
        return iBlocService.findByCapaciteBlocGreaterThan(capacite);
    }

    @GetMapping("/findByNomBlocContaining")
    public List<Bloc> findByNomBlocContaining(@RequestParam String sch) {
        return iBlocService.findByNomBlocContaining(sch);
    }
    @GetMapping("/findAllSortedByName")
    public List<Bloc> findAllSortedByName() {
        return iBlocService.findAllSortedByName();
    }

    @GetMapping("/findByNomBlocOrCapaciteBloc")
    public List<Bloc> findByNomBlocOrCapaciteBloc(
            @RequestParam String nomBloc,
            @RequestParam long capaciteBloc
    ) {
        return iBlocService.findByNomBlocOrCapaciteBloc(nomBloc, capaciteBloc);
    }

    @PostMapping("/findBlocByFoyer")
    public List<Bloc> findBlocByFoyer(@RequestBody Foyer foyer){
        return iBlocService.findBlocByFoyer(foyer);
    }

    @PutMapping("affecterChamberABloc/{nomBloc}")
    Bloc affecterChambresABloc(@RequestBody List<Integer> numeros , @PathVariable("nomBloc") String nomBloc){
        return iBlocService.affecterChambresABloc(numeros , nomBloc);
    }
    @PutMapping("affecterBlocFoyer/{nomBloc}/{nomFoyer}")
    Bloc affecterBlocAFoyer(@PathVariable("nomFoyer") String nomFoyer ,
                            @PathVariable("nomBloc") String nomBloc ){
        return iBlocService.affecterBlocAFoyer(nomBloc, nomFoyer);
    }

}
