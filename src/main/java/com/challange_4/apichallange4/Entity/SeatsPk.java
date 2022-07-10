package com.challange_4.apichallange4.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@Embeddable
public class SeatsPk implements Serializable {
    private int filmCode;
    private int ScheduleId;


}
