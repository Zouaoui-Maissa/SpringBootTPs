package tn.esprit.foyerzouaouimaissa.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
}
