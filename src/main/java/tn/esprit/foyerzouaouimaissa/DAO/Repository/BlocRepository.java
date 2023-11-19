package tn.esprit.foyerzouaouimaissa.DAO.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Foyer;

import java.util.List;


//<Class,typeId "Classe du int exp -> Integer">
@Repository // Optionelle
public interface BlocRepository extends JpaRepository<Bloc, Long> {

    List<Bloc> findBlocByNomBloc(String nomBloc);
    Bloc getBlocByNomBloc(String nomBloc);


    List<Bloc> getBlocsByCapaciteBloc(long capaciteBloc);

    List<Bloc> findByNomBlocAndCapaciteBloc(String nomBloc, long capaciteBloc);

    List<Bloc> findByNomBlocIgnoreCase(String nomBloc);

    List<Bloc> findByCapaciteBlocGreaterThan(long capacite);

    List<Bloc> findByNomBlocContaining(String schaine);

    List<Bloc> findAllByOrderByNomBlocAsc();

    List<Bloc> findByNomBlocOrCapaciteBloc(String nomBloc, long capaciteBloc);

    List<Bloc> findBlocByFoyer(Foyer foyer);

}


