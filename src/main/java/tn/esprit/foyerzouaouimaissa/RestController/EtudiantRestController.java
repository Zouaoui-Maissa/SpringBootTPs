package tn.esprit.foyerzouaouimaissa.RestController;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Chambre;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Etudiant;
import tn.esprit.foyerzouaouimaissa.Services.IEtudiantService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantRestController {

    IEtudiantService iEtudiantService;

    @GetMapping("findAllE")
    List<Etudiant> findAllE(){
        return iEtudiantService.findAllE();
    }

    @PostMapping("/addEtudiant")
    Etudiant addEtudiant(@RequestBody Etudiant e){
        return iEtudiantService.addEtudiant(e);
    }

    @DeleteMapping("/deleteEtudiant")
    public void delete(@RequestBody Etudiant e) {
        iEtudiantService.delete(e);
    }

    @DeleteMapping("/deleteByIdE/{id}")
    public void deleteByIdE(@PathVariable Long id) {
        iEtudiantService.deleteByIdE(id);
    }

    @PutMapping("/editEtudiant")
    public Etudiant editEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.editEtudiant(e);
    }

    @GetMapping("findAllECin/{cin}")
    public List<Etudiant> findAllECin(@PathVariable Long cin) {
        return iEtudiantService.findByCin(cin);
    }

    @GetMapping("findAllEEcole/{ecole}")
    public List<Etudiant> findAllEEcole(@PathVariable String ecole) {
        return iEtudiantService.findByEcole(ecole);
    }

    @GetMapping("findByNomEtAndPrenomEt")
    public List<Etudiant> findByNomEtAndPrenomEt(
            @RequestParam String nomEt,
            @RequestParam String prenomEt
    ) {
        return iEtudiantService.findByNomEtAndPrenomEt(nomEt, prenomEt);
    }

    @GetMapping("/findEtudiantsByDateNaissance/{targetDate}")
    public List<Etudiant> findEtudiantsByDateNaissance(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date targetDate
    ) {
        return iEtudiantService.findEtudiantsByDateNaissance(targetDate);
    }

}
