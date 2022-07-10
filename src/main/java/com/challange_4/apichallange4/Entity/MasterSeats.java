package com.challange_4.apichallange4.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Master_Studio")
@Setter
@Getter
public class MasterSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_studio")
    public int idStudio;
    @Column(name = "studio")
    public String studio;
    @Column(name = "no_Seat")
    public int noSeat;
    @Column(name = "status")
    public boolean status;

}
