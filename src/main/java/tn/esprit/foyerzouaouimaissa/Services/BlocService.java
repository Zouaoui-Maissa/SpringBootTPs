package tn.esprit.foyerzouaouimaissa.Services;

import jakarta.persistence.SecondaryTable;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Bloc;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Chambre;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Foyer;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Universite;
import tn.esprit.foyerzouaouimaissa.DAO.Repository.BlocRepository;
import tn.esprit.foyerzouaouimaissa.DAO.Repository.ChambreRepository;
import tn.esprit.foyerzouaouimaissa.DAO.Repository.FoyerRepository;
import tn.esprit.foyerzouaouimaissa.Services.IBlocService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService{

    @Autowired
    private final BlocRepository blocRepository;
    @Autowired
    private final ChambreRepository chambreRepository;
    @Autowired
    private final FoyerRepository foyerRepository;

    @Override
    public Bloc addBloc(Bloc b) {
        List<Chambre> c = b.getChambres();
        Bloc bloc = blocRepository.save(b);
        c.forEach(chambre -> chambre.setBloc(bloc));
        chambreRepository.saveAll(c);
        return bloc;
    }


    @Override
    public List<Bloc> addBlocs(List<Bloc> blocs) {
        return blocRepository.saveAll(blocs);
    }

    @Override
    public Bloc editBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public List<Bloc> findAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findById(long id) {
        //return blocRepository.findById(id).get();
        //or
        return blocRepository.findById(id).orElse(Bloc.builder().idBloc(0).nomBloc("Pas de bloc").build());
    }

    @Override
    public void deleteById(long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public void delete(Bloc b) {
        blocRepository.delete(b);
    }

    @Override
    public Bloc findByNomBloc(String nomBloc) {
            return blocRepository.getBlocByNomBloc(nomBloc);
        }




    @Override
    public List<Bloc> findByCapaciteBloc(long capaciteBloc) {
        return  blocRepository.getBlocsByCapaciteBloc(capaciteBloc);
    }

    @Override
    public List<Bloc> findByNomBlocAndCapaciteBloc(String nomBloc, long capaciteBloc) {
        return blocRepository.findByNomBlocAndCapaciteBloc( nomBloc,  capaciteBloc);
    }

    @Override
    public List<Bloc> findByNomBlocIgnoreCase(String nomBloc) {
        return blocRepository.findByNomBlocIgnoreCase(nomBloc);
    }
    @Override
    public List<Bloc> findByCapaciteBlocGreaterThan(long capacite) {
        return blocRepository.findByCapaciteBlocGreaterThan(capacite);
    }
    @Override
    public List<Bloc> findByNomBlocContaining(String sch) {
        return blocRepository.findByNomBlocContaining(sch);
    }

    @Override
    public List<Bloc> findAllSortedByName() {
        return blocRepository.findAllByOrderByNomBlocAsc();
    }

    @Override
    public List<Bloc> findByNomBlocOrCapaciteBloc(String nomBloc, long capaciteBloc) {
        return blocRepository.findByNomBlocOrCapaciteBloc(nomBloc, capaciteBloc);
    }
    @Override
    public List<Bloc> findBlocByFoyer(Foyer foyer) {
        return blocRepository.findBlocByFoyer(foyer);
    }

    @Override
    public List<Bloc> findBlocByIdFoyer(long idF) {
        return null;
    }

    @Override
    public List<Bloc> findByFoyerUniversite(Universite u) {
        return null;
    }

    @Override
    public void foyerfindByBlocsIdBloc(long id) {

    }

    @Override
    public Bloc affecterChambresABloc(List<Integer> numChambre, String nomBloc) {
       /* Bloc b = blocRepository.getBlocByNomBloc(nomBloc);
        List<Chambre> chambres = new ArrayList<>();
        numChambre.forEach(numero ->{
            Chambre c = chambreRepository.findByNumeroChambre(numero);
            c.setBloc(b);
            chambreRepository.save(c);
            chambres.add(c);
        });
        b.setChambres(chambres);
        return blocRepository.save(b);*/
        Bloc b = blocRepository.getBlocByNomBloc(nomBloc);
        numChambre.forEach(numero ->{
            Chambre c = chambreRepository.findByNumeroChambre(numero);
            c.setBloc(b);
            chambreRepository.save(c);
        });
        return b;
    }



    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Foyer f = foyerRepository.findFoyerByNomFoyer(nomFoyer);
        Bloc b = blocRepository.getBlocByNomBloc(nomBloc);
        b.setFoyer(f);

        return blocRepository.save(b);
    }
}
