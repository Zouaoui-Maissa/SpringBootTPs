package tn.esprit.foyerzouaouimaissa.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Foyer;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Reservation;
import tn.esprit.foyerzouaouimaissa.Services.IFoyerService;
import tn.esprit.foyerzouaouimaissa.Services.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationRestController {

    IReservationService iReservationService;


    @GetMapping("findAllR")
    List<Reservation> findAllR(){
        return iReservationService.findAllR();
    }

    @PostMapping("/addReservation")
    Reservation addReservation(@RequestBody Reservation r){
        return iReservationService.addReservation(r);
    }

    @DeleteMapping("/deleteReservation")
    public void delete(@RequestBody Reservation r) {
        iReservationService.delete(r);
    }

    @DeleteMapping("/deleteByIdR/{id}")
    public void deleteByIdR(@PathVariable String id) {
        iReservationService.deleteByIdR("");
    }

    @PutMapping("/editReservation")
    public Reservation editReservation(@RequestBody Reservation r) {
        return iReservationService.editReservation(r);
    }


}
