package tn.esprit.foyerzouaouimaissa.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Chambre;
import tn.esprit.foyerzouaouimaissa.DAO.Model.TypeChambre;
import tn.esprit.foyerzouaouimaissa.DAO.Repository.BlocRepository;
import tn.esprit.foyerzouaouimaissa.DAO.Repository.ChambreRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService{

    ChambreRepository chambreRepository;

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public List<Chambre> addChambres(List<Chambre> chambres) {
        return chambreRepository.saveAll(chambres);
    }

    @Override
    public Chambre editChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre findById(long id) {
        //return blocRepository.findById(id).get();
        //or
        return chambreRepository.findById(id).orElse(Chambre.builder().idChambre(0).numeroChambre(0)
                .typeC(TypeChambre.SIMPLE).build());
    }

    @Override
    public void deleteByIdC(long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public void delete(Chambre c) {
        chambreRepository.delete(c);
    }
    public Chambre findByNumeroChambre(long numeroChambre) {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }

    @Override
    public List<Chambre> findByBlocFoyerUniversiteNomUniversiteAndReservationAndAnneeUniversitaireAndReservationEtudiantsNomEt(String nomUniversite, Date anneeUniversitaire, String nomEt) {
        return null;
    }
    BlocRepository blocRepository;
    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc b = blocRepository.getBlocByNomBloc(nomBloc);
        return chambreRepository.findByBloc(b) ;
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type) {
        return chambreRepository.findChamberByBlocFoyerNomFoyerAndTypeCAndReservations_Empty(nomFoyer,type);
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        Bloc b = blocRepository.findById(idBloc).get();
        int c = chambreRepository.countChamberByTypeCAndBloc_IdBloc(type , idBloc);
        return c;
    }

}
