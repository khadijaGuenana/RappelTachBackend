package com.myproject.RappeltacheBack.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
/*
@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor */
public class SousTache {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String SousTacheName;

    @ManyToOne() //fetch = FetchType.LAZY, optional = false
    @JoinColumn(name = "tache_id", nullable = false)
    @JsonIgnore

    private Tache tache;



}
