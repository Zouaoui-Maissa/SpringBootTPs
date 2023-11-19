package tn.esprit.foyerzouaouimaissa.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Chambre;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Etudiant;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Reservation;
import tn.esprit.foyerzouaouimaissa.DAO.Model.TypeChambre;
import tn.esprit.foyerzouaouimaissa.DAO.Repository.ChambreRepository;
import tn.esprit.foyerzouaouimaissa.DAO.Repository.EtudiantRepository;
import tn.esprit.foyerzouaouimaissa.DAO.Repository.ReservationRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Service
public class ReservationService implements IReservationService {
    ReservationRepository reservationRepository;
    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public List<Reservation> addReservations(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public Reservation editReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public List<Reservation> findAllR() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(String id) {
        return reservationRepository.findById(id).orElse(Reservation.builder().idReservation("")
                .anneUniversitaire(new Date()).estValide(true).build());
    }

    @Override
    public void deleteByIdR(String id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public void delete(Reservation r) {
        reservationRepository.delete(r);
    }

    ChambreRepository chamberRepository ;
    EtudiantRepository etudiantRepository ;
    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Long numChambre, long cin) {
        /*Chambre c = chamberRepository.findByNumeroChambre(numChambre);
        Etudiant e = (Etudiant) etudiantRepository.findByCin(cin);
        List<Etudiant> etud = new ArrayList<>( ) ;
        etud.add(e);
        Reservation r = new Reservation();
        r.setIdReservation(e.getNomEt()+"RES");
        r.setAnneUniversitaire(new Date());
        r.setEstValide(false);
        r.setEtudiants(etud);
        Set<Reservation> reservationsList = new HashSet<>();
        reservationsList.add(r);
        c.setReservations(reservationsList);
        e.setReservations(reservationsList);
        reservationRepository.save(r);
        etudiantRepository.save(e);
        chamberRepository.save(c);
        return r;*/

        LocalDate dateDebutAU;
        LocalDate dateFinAU;

        int numReservation;
        int year = LocalDate.now().getYear() % 100;
        if (LocalDate.now().getMonthValue() <= 7) {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + (year - 1)), 9, 15);
            dateFinAU = LocalDate.of(Integer.parseInt("20" + year), 6, 30);
        } else {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + year), 9, 15);
            dateFinAU = LocalDate.of(Integer.parseInt("20" + (year + 1)), 6, 30);
        }

        Etudiant e = etudiantRepository.findByCin(cin); //Pour verifier l existance de l'etudiant
        Boolean test = false;
        Chambre c =new Chambre();

        //La disponibilité des chambres , s'il y a des reservatins ou non
        if (e != null) {
            c = chamberRepository.findByNumeroChambre(numChambre);
            Set<Reservation> reservations = c.getReservations();
            int i = (int) reservations.stream().filter(Reservation::isEstValide).count();
            if(c.getTypeC().equals(TypeChambre.SIMPLE)&& i ==0){
                test = true;
            } else if (c.getTypeC().equals(TypeChambre.DOUBLE) && i<=1) {
                test = true;
            } else if (c.getTypeC().equals(TypeChambre.TRIPLE) && i<=2) {
                test = true;
            }
        }
        if(!test){
        return  new Reservation();
    }else {
            Reservation r =new Reservation();
            r.setIdReservation(dateDebutAU.getYear()+"/"+dateFinAU.getYear()+"-"+c.getBloc().getNomBloc()
            +"-"+c.getNumeroChambre()+"-"+e.getCin());

            Date anneUniversitaire = r.getAnneUniversitaire(new Date());
            r.setEstValide(true);
            r = reservationRepository.save(r);
            c.getReservations().add(r);
            chamberRepository.save(c);
            r.getEtudiants().add(e);
            return reservationRepository.save(r);
        }
    }

    @Override
    public long getReservationParAnneeUniversitaire(LocalDate debutAnnee, LocalDate finAnnee) {
        return 0;
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant e = etudiantRepository.findByCin(cinEtudiant);
        return null;
    }
}
