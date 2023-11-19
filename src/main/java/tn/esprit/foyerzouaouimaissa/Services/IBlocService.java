package tn.esprit.foyerzouaouimaissa.Services;

import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Foyer;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Universite;

import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc b);
    List<Bloc> addBlocs(List<Bloc> blocs);
    Bloc editBloc(Bloc b);
    List<Bloc> findAll();
    Bloc findById(long id);
    void deleteById(long id);
    void delete(Bloc b);

    Bloc findByNomBloc(String nomBloc);

    List<Bloc> findByCapaciteBloc(long capaciteBloc);

    List<Bloc> findByNomBlocAndCapaciteBloc(String nomBloc, long capaciteBloc);
    List<Bloc> findByNomBlocIgnoreCase(String nomBloc);
    List<Bloc> findByCapaciteBlocGreaterThan(long capacite);
    List<Bloc> findByNomBlocContaining(String sch);
    List<Bloc> findAllSortedByName();
    List<Bloc> findByNomBlocOrCapaciteBloc(String nomBloc, long capaciteBloc);
    List<Bloc> findBlocByFoyer(Foyer foyer);
    List <Bloc> findBlocByIdFoyer(long idF);
    //Recherche dun bloc par foyer specfique dans une universite donnée
    List<Bloc> findByFoyerUniversite(Universite u);
    //Recherche dun foyer dun bloc spésifique
    void foyerfindByBlocsIdBloc(long id);

    Bloc affecterChambresABloc(List<Integer> numChambre, String nomBloc) ;

    Bloc affecterBlocAFoyer( String nomBloc, String nomFoyer) ;

}
