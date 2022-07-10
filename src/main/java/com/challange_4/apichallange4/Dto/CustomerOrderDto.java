package com.challange_4.apichallange4.Dto;

import com.challange_4.apichallange4.Entity.Costumer;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CustomerOrderDto {
    private int idTiket;
    private int idSeat;
    private int scheduleId;
    private int filmCode;
    private Costumer idUser;
    private boolean status;
}
