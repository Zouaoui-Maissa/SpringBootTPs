package tn.esprit.foyerzouaouimaissa.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Foyer;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Universite;

import java.util.List;

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
    List<Foyer> findFoyerByCapaciteFoyer(long capacity);

    Foyer findFoyerByUniversite(Universite u);

    Foyer findFoyerByNomFoyer(String nomFoyer);
}
