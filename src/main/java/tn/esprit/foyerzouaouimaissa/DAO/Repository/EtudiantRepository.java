package tn.esprit.foyerzouaouimaissa.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Etudiant;

import java.util.Date;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    Etudiant findByCin(long cin);
    List<Etudiant> getEtudiantByCin(long cin);

    List<Etudiant> findByEcole(String ecole);
    List<Etudiant> getEtudiantByEcole(String ecole);

    List<Etudiant> findByNomEtAndPrenomEt(String nomEt, String prenomEt);

    List<Etudiant> findEtudiantsByDateNaissance(@Param("targetDate") Date targetDate);

}
