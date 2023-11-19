package tn.esprit.foyerzouaouimaissa.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    Universite findUniversiteByNomUniversite(String nomUniversite);

}
