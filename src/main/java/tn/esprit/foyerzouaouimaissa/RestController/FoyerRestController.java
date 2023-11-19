package tn.esprit.foyerzouaouimaissa.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Etudiant;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Foyer;
import tn.esprit.foyerzouaouimaissa.Services.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
public class FoyerRestController {

    IFoyerService iFoyerService;


    @GetMapping("findAllF")
    List<Foyer> findAllF(){
        return iFoyerService.findAllF();
    }

    @PostMapping("/addFoyer")
    Foyer addFoyer(@RequestBody Foyer f){
        return iFoyerService.addFoyer(f);
    }

    @DeleteMapping("/deleteFoyer")
    public void delete(@RequestBody Foyer f) {
        iFoyerService.delete(f);
    }

    @DeleteMapping("/deleteByIdF/{id}")
    public void deleteByIdF(@PathVariable Long id) {
        iFoyerService.deleteByIdF(id);
    }

    @PutMapping("/editFoyer")
    public Foyer editFoyer(@RequestBody Foyer f) {
        return iFoyerService.editFoyer(f);
    }
}
