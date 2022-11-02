package com.myproject.RappeltacheBack.Controller;

import com.myproject.RappeltacheBack.Entity.Category;
import com.myproject.RappeltacheBack.Entity.SousTache;
import com.myproject.RappeltacheBack.Entity.Tache;
import com.myproject.RappeltacheBack.Exception.ResourceNotFoundException;
import com.myproject.RappeltacheBack.Service.CategoryService;
import com.myproject.RappeltacheBack.Service.TacheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TacheController {
    private TacheService tacheService;
    private CategoryService categoryService;
    public TacheController(TacheService tacheService, CategoryService categoryService) {
        this.tacheService = tacheService;

        this.categoryService = categoryService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/saveTache") //mazal category
    public ResponseEntity<Tache> SaveTache(@RequestBody Tache tache){
    tache.setCategory(categoryService.findCategoryById(24));
      Tache tache1=  tacheService.saveTache(tache);
        return new ResponseEntity<>(tache1,HttpStatus.CREATED);
    }
    @CrossOrigin(origins ="http://localhost:4200")
    @GetMapping(path = "/tachesList")
    public ResponseEntity<List<Tache>>getAllTache(){
        List<Tache>list=tacheService.getAllTahe();
        if (list.isEmpty()){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
        return new ResponseEntity<List<Tache>>(list,HttpStatus.OK);
    }
    @GetMapping(path = "/getTacheById/{tacheId}")
    public  ResponseEntity<Tache> getTacheById(@PathVariable("tacheId") Long tacheId ){
     Tache tache=tacheService.findTacheById(tacheId);
      return new ResponseEntity<Tache>(tache,HttpStatus.OK);

    }
    @GetMapping("/getAllTacheByCategory/{categoryId}")
    public ResponseEntity<List<Tache>>getTachesByCategory(@PathVariable("categoryId") long categoryId ){
        if(categoryService.findCategoryById(categoryId)==null){
            throw new ResourceNotFoundException("Not found category with id = " + categoryId);

        }
        List<Tache> listTache = tacheService.findTacheByCategory(categoryId);
        return new ResponseEntity<> (listTache,HttpStatus.OK);
    }



   @PutMapping("/updateTache/{tacheId}")
    public ResponseEntity<Tache>updateTache (@PathVariable("tacheId")long tacheId ,@RequestBody Tache tache ){
        Tache tachefromDB=tacheService.findTacheById(tacheId);
       // Category categoryfromDB=categoryService.findCategoryByCategoryName(tache.getCategory().getCategoryName());
      //  tachefromDB.setCategory(tache.getCategory());
        tachefromDB.setDate(tache.getDate());
        tachefromDB.setTacheName(tache.getTacheName());
        tachefromDB.setDescription(tache.getDescription());
        tachefromDB.setFinished(tache.isFinished());
        tachefromDB.setCategory(tache.getCategory());
        return new ResponseEntity<>(tacheService.saveTache(tachefromDB),HttpStatus.OK);
   }
    @PutMapping("{tacheid}/updatecategory")
    public ResponseEntity<String>updateTacheCategory (@PathVariable("tacheid")long tacheId ,@RequestBody Category CategoryRequest){
        Tache tachefromDB=tacheService.findTacheById(tacheId);
       // Category category=categoryService.findCategoryByCategoryName(CategoryName);

        tachefromDB.setCategory(CategoryRequest);
        return new ResponseEntity<>("tache updated hya "+tacheService.saveTache(tachefromDB) +"category hya " +CategoryRequest.getCategoryName() ,HttpStatus.OK);
    }

    @DeleteMapping("/deleteTache/{tacheId}")
    public ResponseEntity<HttpStatus>deleteTache(@PathVariable ("{tacheId}") long tacheId){
        tacheService.DeleteTache(tacheId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

   }
    @DeleteMapping("/deleteAllTache")
    public ResponseEntity<HttpStatus> deleteAllTaches() {
        tacheService.DeleteAllTache();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/taches/finished")
    public ResponseEntity<List<Tache>> findByfinished() {
        List<Tache> taches = (List<Tache>) tacheService.findFinishedTaches(true);
        if (taches.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(taches, HttpStatus.OK);
    }


}
