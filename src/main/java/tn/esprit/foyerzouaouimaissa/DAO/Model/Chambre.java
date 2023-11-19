package tn.esprit.foyerzouaouimaissa.DAO.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Chambre")

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long idChambre;

    @Column(name = "numeroChambre")
    private long numeroChambre;

    @Column(name = "typeC")
    private TypeChambre typeC;

    @ManyToOne
    Bloc bloc;

    @OneToMany
    Set<Reservation> reservations;
}   
