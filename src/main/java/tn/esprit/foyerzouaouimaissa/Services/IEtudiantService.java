package tn.esprit.foyerzouaouimaissa.Services;

import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Etudiant;

import java.util.Date;
import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant e);
    List<Etudiant> addEtudiants(List<Etudiant> etudiants);
    Etudiant editEtudiant(Etudiant e);
    List<Etudiant> findAllE();
    Etudiant findById(long id);
    void deleteByIdE(long id);
    void delete(Etudiant e);
    List<Etudiant> findByCin(long cin);

    List<Etudiant> findByEcole(String ecole);

    List<Etudiant> findByNomEtAndPrenomEt(String nomEt, String prenomEt);
    List<Etudiant> findEtudiantsByDateNaissance(Date targetDate);

    List<Etudiant> findByNomEcoleAndDateNaissanceAfter(String nomEcole,Date d);
}
