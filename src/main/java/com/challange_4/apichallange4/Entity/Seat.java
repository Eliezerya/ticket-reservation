package com.challange_4.apichallange4.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Seats")
@Setter
@Getter
public class Seat {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "film_code", column = @Column(name = "film_code")), //kiri nama variabel/atribut , kanan nama column
            @AttributeOverride(name = "ScheduleId", column = @Column(name = "schedule_id"))
    })
    private SeatsPk seatsId;

    @Column(name = "name_studio")
    private String nameStudio;
    @Column(name = "noKursi")
    private int noKursi;
}
