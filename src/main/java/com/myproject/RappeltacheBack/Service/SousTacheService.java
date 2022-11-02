package com.myproject.RappeltacheBack.Service;

import com.myproject.RappeltacheBack.Entity.SousTache;

import java.util.List;

public interface SousTacheService {
    public SousTache addSousTache(SousTache sousTache);
    public void deleteSousTache(long idSousTache);
    public void deleteSousTacheByTacheID(long tacheId);
    public List<SousTache> getAllSousTachebyTache(Long tacheId);
    public SousTache getSousTacheById(Long id);



}
