package tn.esprit.foyerzouaouimaissa.DAO.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Etudiant")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;

    @Column(name = "nomEt")
    private String nomEt;

    @Column(name = "prenomEt")
    private String prenomEt;

    @Column(name = "cin")
    private long cin;

    @Column(name = "ecole")
    private String ecole;

    @Column(name = "dateNaissance")
    private Date dateNaissance;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}


