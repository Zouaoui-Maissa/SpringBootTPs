package tn.esprit.foyerzouaouimaissa.DAO.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
    private String idReservation;

    @Column(name = "anneeUniversitaire")
    private Date anneUniversitaire;

    @Column(name = "estValide")
    private boolean estValide;

    @ManyToMany(mappedBy ="reservations" ,cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;
}
