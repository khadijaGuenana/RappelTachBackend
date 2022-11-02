package com.myproject.RappeltacheBack.Service;

import com.myproject.RappeltacheBack.Entity.Category;
import com.myproject.RappeltacheBack.Entity.Tache;
import com.myproject.RappeltacheBack.Repository.TacheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacheServiceImpl implements TacheService{
   private TacheRepository tacheRepository;

    public TacheServiceImpl(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    @Override
    public Tache saveTache(Tache tache) {

        return tacheRepository.save(tache);
    }

    @Override
    public List<Tache> getAllTahe() {
        return tacheRepository.findAll();
    }

    @Override
    public Tache findTacheById(Long idTache) {
       return tacheRepository.findById(idTache).get();
    }

    @Override
    public Tache findFinishedTaches(boolean f) {
      return   tacheRepository.findByFinished(f);
    }

    @Override
    public List<Tache> findTacheByCategory(long idCategory) {


        return  tacheRepository.findByCategoryId(idCategory);
    }


    @Override
    public void  DeleteTache(long idTache) {
         tacheRepository.deleteById(idTache);
    }

    @Override
    public void DeleteAllTache() {
        tacheRepository.deleteAll();
    }
}
