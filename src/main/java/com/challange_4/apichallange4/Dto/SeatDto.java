package com.challange_4.apichallange4.Dto;

import com.challange_4.apichallange4.Entity.SeatsPk;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SeatDto {
    private SeatsPk seatsId;
    private int noKursi;
    private String nameStudio;

    private MasterSeatsDto detailSeat;
}
