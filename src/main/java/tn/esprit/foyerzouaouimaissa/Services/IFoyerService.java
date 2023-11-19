package tn.esprit.foyerzouaouimaissa.Services;


import tn.esprit.foyerzouaouimaissa.DAO.Model.Chambre;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addFoyer(Foyer f);
    List<Foyer> addFoyers(List<Foyer> foyers);
    Foyer editFoyer(Foyer f);
    List<Foyer> findAllF();
    Foyer findById(long id);
    void deleteByIdF(long id);
    void delete(Foyer c);

    //Recherche des foyer d'un blocayant une capacite specifique
    List<Foyer> findFoyerByBlocCapaciteBloc(long capaciteBloc);

    //Recherche du foyer par numero de chambre
    //Chambre findChambreByNumChambre(long numChambre);


}
