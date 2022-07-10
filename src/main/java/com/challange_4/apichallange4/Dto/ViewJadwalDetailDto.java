package com.challange_4.apichallange4.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;


@Setter
@Getter
public class ViewJadwalDetailDto {
    private int idJadwal;
    private Date selesaiTayang;
    private String filmName;
    private int codeFilms;
    private long hargaTiket;
}
