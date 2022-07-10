package com.challange_4.apichallange4.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "vw_jadwal")
public class ViewJadwalDetail {
    @Id
    @Column(name = "id_jadwal")
    private int idJadwal;
    @Column(name = "selesai_tayang")
    private Date selesaiTayang;
    @Column(name = "film_name")
    private String filmName;
    @Column(name = "code_films")
    private int codeFilms;
    @Column(name = "harga_tiket")
    private long hargaTiket;
}
