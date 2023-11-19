package tn.esprit.foyerzouaouimaissa.DAO.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Universite")
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite;

    @Column(name = "nomUniversite")
    private String nomUniversite;

    @Column(name = "adresse")
    private String adresse;


    @OneToOne(cascade = CascadeType.ALL)
    Foyer foyer;

}
