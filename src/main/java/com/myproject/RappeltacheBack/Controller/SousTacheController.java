package com.myproject.RappeltacheBack.Controller;

import com.myproject.RappeltacheBack.Entity.SousTache;
import com.myproject.RappeltacheBack.Entity.Tache;
import com.myproject.RappeltacheBack.Exception.ResourceNotFoundException;
import com.myproject.RappeltacheBack.Service.SousTacheService;
import com.myproject.RappeltacheBack.Service.TacheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SousTacheController {
    private SousTacheService sousTacheService;
    private TacheService tacheService;
    public SousTacheController(SousTacheService sousTacheService, TacheService tacheService) {
        this.sousTacheService = sousTacheService;
        this.tacheService = tacheService;
    }

    @PostMapping("/{tacheId}/ajouterSousTache")
    public ResponseEntity<SousTache> ajouterSousTache(@PathVariable("tacheId") long tacheId , @RequestBody SousTache sousTacheRequest){
         Tache tachefromDB=tacheService.findTacheById(tacheId);
         sousTacheRequest.setTache(tachefromDB);
       //  sousTacheRequest.setSousTacheName(sousTacheR.getSousTacheName());

        SousTache sousTache=sousTacheService.addSousTache(sousTacheRequest);
        return new ResponseEntity<>(sousTache, HttpStatus.CREATED);

    }
    @PutMapping("/sousTaches/{sousTachid}")
    public ResponseEntity<SousTache> updateSousTache(@PathVariable("sousTachid") Long sousTachid , @RequestBody SousTache sousTacheRequest){
        SousTache sousTache=sousTacheService.getSousTacheById(sousTachid);
        sousTache.setSousTacheName(sousTacheRequest.getSousTacheName());
       return new ResponseEntity<>(sousTacheService.addSousTache(sousTache),HttpStatus.OK);
    }
    @GetMapping("/{tacheId}/listSousTache")
    public ResponseEntity<List<SousTache>>getAllSousTacheByTacheId(@PathVariable("tacheId") long tacheId ){
      if(tacheService.findTacheById(tacheId)==null){
          throw new ResourceNotFoundException("Not found tache with id = " + tacheId);

      }

        List<SousTache> listSTache =sousTacheService.getAllSousTachebyTache(tacheId);
        return new ResponseEntity<> (listSTache,HttpStatus.OK);
    }


     @GetMapping("/sousTaches/{id}")
    public ResponseEntity<SousTache> getSousTacheById(@PathVariable("id") Long id ){
       SousTache sousTache=sousTacheService.getSousTacheById(id);
     if (sousTache==null){
         throw new ResourceNotFoundException("Not found sousTache with id = " + id);

     }
     return new ResponseEntity<>(sousTache,HttpStatus.OK);
     }
    @DeleteMapping("/sousTache/{id}")
    public ResponseEntity<HttpStatus> deleteSousTache(@PathVariable("id") long id) {
        sousTacheService.deleteSousTache(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{tacheId}/sousTache")
    public ResponseEntity<List<SousTache>> deleteAllSousTacheOfTache(@PathVariable("tacheId") Long tacheId) {
        if (tacheService.findTacheById(tacheId)==null) {
            throw new ResourceNotFoundException("Not found Tache with id = " + tacheId);
        }
        sousTacheService.deleteSousTacheByTacheID(tacheId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
