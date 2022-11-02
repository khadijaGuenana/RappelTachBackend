package com.myproject.RappeltacheBack.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor

public class Tache {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tacheName;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date date;
    private boolean finished;
    private priorite priorite;
   @ManyToOne() //fetch = FetchType.LAZY, optional = false
   @JoinColumn(name = "category_id")
   @JsonIgnore
    private  Category category;

    public Tache(Long id, String tacheName, Date date, String description,  Category category) {
    this.tacheName=tacheName;
    this.date=date;
    this.description=description;

    this.category=category;
    //finished

    }


    //private String Rappel

}
