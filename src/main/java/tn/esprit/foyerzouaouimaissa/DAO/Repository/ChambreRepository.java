package tn.esprit.foyerzouaouimaissa.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Chambre;
import tn.esprit.foyerzouaouimaissa.DAO.Model.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    Chambre findByNumeroChambre(long numeroChambre);
    //JPQL() et SQL()
    //Autre meth pour recuperer numero chambre
    //@Query("select c from Chambre c where c.numeroChambre =?1") // or c.numeroChambre @Param()c.numeroChambre:=c "@Param valide pour jpql et sql"
    // @Query("select c from Chamber c where c.numerochamber= ?1")
    // Chamber chamberByNumeroChamber(long numero);
    //@Query("select c from Chamber c where c.numerochamber=:num")
    // Chamber chamberByNumeroChamber(@Param(value="num") long num)  ;

    //SQL
    @Query(nativeQuery = true,value = "select * from Chambre where numeroChamobre=")


    int countChamberByTypeCAndBloc_IdBloc(TypeChambre typeChamber , long idBloc);
    List<Chambre> findChamberByBlocFoyerNomFoyerAndTypeCAndReservations_Empty(String NomFoyer , TypeChambre type);
    List<Chambre> findByBloc(Bloc b);

    @Query("select c from Chambre c where c.numeroChambre=?1")
    List <Chambre> selectByNum(long num);

    @Query("select c from Chambre c where c.numeroChambre=:num")
    List <Chambre> selectByNum2(@Param(value ="num") long num) ;

    @Query(value = "select * from chambre where numeroChambre=?1",nativeQuery = true)
    List<Chambre> selectByNumSQL(long num);
}

