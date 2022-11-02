package com.myproject.RappeltacheBack.Repository;

import com.myproject.RappeltacheBack.Entity.SousTache;
import com.myproject.RappeltacheBack.Entity.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository <Tache,Long>{

  public List<Tache> findByCategoryId(long idCategory);
  public Tache findByFinished(boolean f);
}
