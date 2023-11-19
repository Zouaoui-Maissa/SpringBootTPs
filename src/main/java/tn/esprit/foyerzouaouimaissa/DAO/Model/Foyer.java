package tn.esprit.foyerzouaouimaissa.DAO.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Foyer")
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;

    @Column(name = "nomFoyer")
    private String nomFoyer;

    @Column(name = "capaciteFoyer")
    private long capaciteFoyer;

    @OneToOne(mappedBy = "foyer" , cascade = CascadeType.ALL)
    Universite universite;

    @OneToMany(mappedBy = "foyer")
    List<Bloc> blocs;
}
