package com.challange_4.apichallange4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer_order")
@Getter
@Setter
public class CostumerOrder {
    @Id
    @Column(name = "id_tiket")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTiket;
    @Column(name = "id_seat")
    private int idSeat;
    @Column(name = "schedule_id")
    private int scheduleId;
    @Column(name = "film_code")
    private int filmCode;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_users", nullable = false)
    private Costumer idUser;

}
