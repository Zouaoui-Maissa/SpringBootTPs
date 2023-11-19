package tn.esprit.foyerzouaouimaissa.Services;

import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Chambre;
import tn.esprit.foyerzouaouimaissa.DAO.Model.TypeChambre;

import java.util.Date;
import java.util.List;

public interface IChambreService {
    Chambre addChambre(Chambre c);
    List<Chambre> addChambres(List<Chambre> chambres);
    Chambre editChambre(Chambre c);
    List<Chambre> findAll();
    Chambre findById(long id);
    void deleteByIdC(long id);
    void delete(Chambre c);
    Chambre findByNumeroChambre(long numeroChambre);

    List<Chambre> findByBlocFoyerUniversiteNomUniversiteAndReservationAndAnneeUniversitaireAndReservationEtudiantsNomEt(String nomUniversite, Date anneeUniversitaire, String nomEt);
    List<Chambre> getChambresParNomBloc( String nomBloc) ;

    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre( String nomFoyer,TypeChambre type) ;
    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) ;

}
