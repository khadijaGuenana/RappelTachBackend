package com.myproject.RappeltacheBack.Controller;

import com.myproject.RappeltacheBack.Entity.Category;
import com.myproject.RappeltacheBack.Entity.Tache;
import com.myproject.RappeltacheBack.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
   @PostMapping(path = "/addCategory")
    public ResponseEntity<String> saveCategory(@RequestBody Category category) {
    categoryService.addCategory(category);
    return new ResponseEntity<String>("la category est ajoute avec succes", HttpStatus.OK);
   }
    @CrossOrigin(origins ="http://localhost:4200")
    @GetMapping(path = "/categoryList")
    public ResponseEntity<List<Category>>getAllCategory(){
        List<Category>list=categoryService.getAll();
        return new ResponseEntity<List<Category>>(list,HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/getCategoryById/{categoryId}")
    public  ResponseEntity<Category> getcategoryById(@PathVariable("categoryId") Long categoryId ){
        Category category=categoryService.findCategoryById(categoryId);
        return new ResponseEntity<Category>(category,HttpStatus.OK);

    }



    }



