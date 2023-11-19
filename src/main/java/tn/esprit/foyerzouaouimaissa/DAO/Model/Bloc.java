package tn.esprit.foyerzouaouimaissa.DAO.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bloc")
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idBloc;

    @Column(name = "nomBloc")
    private String nomBloc;

    @Column(name = "capaciteBloc")
    private long capaciteBloc;

    @ManyToOne
    Foyer foyer;

    @JsonIgnore
    @OneToMany(mappedBy ="bloc" )
    List<Chambre> chambres;
}
