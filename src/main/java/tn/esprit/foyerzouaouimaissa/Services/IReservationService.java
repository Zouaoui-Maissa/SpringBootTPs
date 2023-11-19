package tn.esprit.foyerzouaouimaissa.Services;

import tn.esprit.foyerzouaouimaissa.DAO.Model.Foyer;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {

    Reservation addReservation(Reservation r);
    List<Reservation> addReservations(List<Reservation> reservations);
    Reservation editReservation(Reservation r);
    List<Reservation> findAllR();
    Reservation findById(String id);
    void deleteByIdR(String id);

    void delete(Reservation r);
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (Long numChambre, long cin) ;

    long getReservationParAnneeUniversitaire(LocalDate debutAnnee, LocalDate finAnnee ) ;

    Reservation annulerReservation (long cinEtudiant) ;
}
