package tn.esprit.foyerzouaouimaissa.Services;

import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite u);
    List<Universite> addUniversites(List<Universite> universites);
    Universite editUniversite(Universite u);
    List<Universite> findAllU();
    Universite findByIdU(long id);
    void deleteByIdU(long id);
    void delete(Universite u);

    Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    Universite desaffecterFoyerAUniversite(long idUniversite);}
