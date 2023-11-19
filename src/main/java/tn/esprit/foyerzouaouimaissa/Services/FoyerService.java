package tn.esprit.foyerzouaouimaissa.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Etudiant;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Foyer;
import tn.esprit.foyerzouaouimaissa.DAO.Model.Universite;
import tn.esprit.foyerzouaouimaissa.DAO.Repository.EtudiantRepository;
import tn.esprit.foyerzouaouimaissa.DAO.Repository.FoyerRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService {
    FoyerRepository foyerRepository;

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> addFoyers(List<Foyer> foyers) {
        return foyerRepository.saveAll(foyers);
    }

    @Override
    public Foyer editFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> findAllF() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findById(long id) {
        //return blocRepository.findById(id).get();
        //or
        return foyerRepository.findById(id).orElse(Foyer.builder().idFoyer(0).nomFoyer("")
                .capaciteFoyer(0).build());
    }

    @Override
    public void deleteByIdF(long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public void delete(Foyer f) {
        foyerRepository.delete(f);
    }

    @Override
    public List<Foyer> findFoyerByBlocCapaciteBloc(long capaciteBloc) {
        return null;
    }


}

