package com.myproject.RappeltacheBack.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor

public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private Collection<Tache> taches;



    public Category(Long aLong, String category1) {
        this.categoryName=category1;
    }
}
