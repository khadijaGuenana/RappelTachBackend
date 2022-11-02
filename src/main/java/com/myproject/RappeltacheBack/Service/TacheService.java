package com.myproject.RappeltacheBack.Service;

import com.myproject.RappeltacheBack.Entity.Category;
import com.myproject.RappeltacheBack.Entity.SousTache;
import com.myproject.RappeltacheBack.Entity.Tache;

import java.util.List;
import java.util.Optional;

public interface TacheService {
   public Tache saveTache(Tache tache);
    public List<Tache> getAllTahe();
    public Tache findTacheById(Long idTache);
    public Tache findFinishedTaches(boolean f);
    public  List<Tache> findTacheByCategory(long idCategory);

    public void DeleteTache(long idTache);
    public void DeleteAllTache();

}
