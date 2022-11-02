package com.myproject.RappeltacheBack.Repository;

import com.myproject.RappeltacheBack.Entity.SousTache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SousTacheRepository extends JpaRepository<SousTache,Long> {
   List<SousTache> findByTacheId(Long tacheId);
   @Transactional
   void deleteByTacheId(Long tacheId);
}
