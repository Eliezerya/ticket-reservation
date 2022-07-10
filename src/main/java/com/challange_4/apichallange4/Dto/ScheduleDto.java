package com.challange_4.apichallange4.Dto;

import com.challange_4.apichallange4.Entity.Film;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ScheduleDto {
    private int ScheduleId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date mulaiTayang;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date selesaiTayang;
    private long harga;
    private Film films;

}
