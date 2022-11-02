package com.myproject.RappeltacheBack.Service;

import com.myproject.RappeltacheBack.Entity.SousTache;
import com.myproject.RappeltacheBack.Repository.SousTacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SousTacheServiceImpl implements SousTacheService {
    @Autowired
    private SousTacheRepository sousTacheRepository;
    @Override
    public SousTache addSousTache(SousTache sousTache) {
        return (SousTache) sousTacheRepository.save(sousTache);
    }

    @Override
    public void deleteSousTache(long idSousTache) {
           sousTacheRepository.deleteById(idSousTache);
    }

    @Override
    public void deleteSousTacheByTacheID(long tacheId) {
        sousTacheRepository.deleteByTacheId(tacheId);
    }


    @Override
    public List<SousTache> getAllSousTachebyTache(Long tacheId) {

        return sousTacheRepository.findByTacheId(tacheId);
    }

    @Override
    public SousTache getSousTacheById(Long id) {
        return sousTacheRepository.findById(id).get();
    }


}
