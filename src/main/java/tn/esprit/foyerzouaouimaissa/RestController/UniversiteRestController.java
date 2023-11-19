package tn.esprit.foyerzouaouimaissa.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Foyer;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Reservation;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Universite;
import tn.esprit.foyerzouaouimaissa.Services.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteRestController {
    IUniversiteService iUniversiteService;


    @GetMapping("findAllU")
    List<Universite> findAllU(){
        return iUniversiteService.findAllU();
    }

    @PostMapping("/addUniversite")
    Universite addUniversite(@RequestBody Universite u){
        return iUniversiteService.addUniversite(u);
    }

    @DeleteMapping("/deleteUniversite")
    public void delete(@RequestBody Universite u) {
        iUniversiteService.delete(u);
    }

    @DeleteMapping("/deleteByIdU/{id}")
    public void deleteByIdU(@PathVariable Long id) {
        iUniversiteService.deleteByIdU(id);
    }

    @PutMapping("/editUniversite")
    public Universite editUniversite(@RequestBody Universite u) {
        return iUniversiteService.editUniversite(u);
    }

    @PutMapping("/updateUniversite/{idFoyer}/{nomUniversite}")
    Universite affecterFoyerAuniversite(@PathVariable("idFoyer") long idFoyer ,
                                        @PathVariable("nomUniversite") String nomUniversite){
        return iUniversiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }

    @PutMapping("desaffecterUniversite/{idUnive}")
    Universite descaffecterFoyer(@PathVariable("idUnive")long id){
        return iUniversiteService.desaffecterFoyerAUniversite(id);
    }
}
