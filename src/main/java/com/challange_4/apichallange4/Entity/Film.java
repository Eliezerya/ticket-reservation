package com.challange_4.apichallange4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Films")
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_code")
    private int filmCode;
    @Column(name = "film_name")
    private String filmName;
    @Column(name = "film_status")
    private boolean status;

}