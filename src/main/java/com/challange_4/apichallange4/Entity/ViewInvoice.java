package com.challange_4.apichallange4.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "vw_invoice")
public class ViewInvoice {
    @Id
    @Column(name = "id_users")
    private int idUsers;
    @Column(name = "id_tiket")
    private int idTiket;
    @Column(name = "harga_tiket")
    private int hargaTiket;
    @Column(name = "mulai_tayang")
    private Date mulaiTayang;
    @Column(name = "selesai_tayang")
    private Date selesaiTayang;
    @Column(name = "username")
    private String username;
    @Column(name = "no_seat")
    private int noSeat;
    @Column(name = "studio")
    private String studio;
    @Column(name = "film_name")
    private String filmName;


}
