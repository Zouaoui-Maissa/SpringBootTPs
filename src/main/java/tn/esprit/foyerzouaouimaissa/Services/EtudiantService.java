package tn.esprit.foyerzouaouimaissa.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Chambre;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Etudiant;
import tn.esprit.foyerzouaouimaissa.DAO.Model.TypeChambre;
import tn.esprit.foyerzouaouimaissa.DAO.Repository.ChambreRepository;
import tn.esprit.foyerzouaouimaissa.DAO.Repository.EtudiantRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService {
    EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant editEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> findAllE() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findById(long id) {
        //return blocRepository.findById(id).get();
        //or
        return etudiantRepository.findById(id).orElse(Etudiant.builder().idEtudiant(0).nomEt("")
                .prenomEt("").cin(0).ecole("").dateNaissance(new Date()).build());
    }

    @Override
    public void deleteByIdE(long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public void delete(Etudiant e) {
        etudiantRepository.delete(e);
    }


    @Override
    public List<Etudiant> findByCin(long cin) {
        return  etudiantRepository.getEtudiantByCin(cin);
    }

    @Override
    public List<Etudiant> findByEcole(String ecole) {
        return etudiantRepository.getEtudiantByEcole(ecole);
    }

    @Override
    public List<Etudiant> findByNomEtAndPrenomEt(String nomEt, String prenomEt) {
        return etudiantRepository.findByNomEtAndPrenomEt(nomEt, prenomEt);
    }

    @Override
    public List<Etudiant> findEtudiantsByDateNaissance(Date targetDate) {
        return etudiantRepository.findEtudiantsByDateNaissance(targetDate);
    }

    @Override
    public List<Etudiant> findByNomEcoleAndDateNaissanceAfter(String nomEcole, Date d) {
        return null;
    }


}


