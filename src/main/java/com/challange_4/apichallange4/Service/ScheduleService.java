package com.challange_4.apichallange4.Service;


import com.challange_4.apichallange4.Dto.ScheduleDto;
import com.challange_4.apichallange4.Entity.Film;
import com.challange_4.apichallange4.Entity.Schedule;
import com.challange_4.apichallange4.Repository.FilmRepo2;
import com.challange_4.apichallange4.Repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScheduleService {
    @Autowired
    ScheduleRepo scheduleRepo;
    @Autowired
    FilmRepo2 filmsRepo2;

    public Schedule schedules_submit(ScheduleDto scheduleDto, int filmCode){
        Schedule schedules = new Schedule();
        Film films = filmsRepo2.findById(filmCode);
        schedules.setScheduleId(scheduleDto.getScheduleId());
        schedules.setMulaiTayang(scheduleDto.getMulaiTayang());
        schedules.setSelesaiTayang(scheduleDto.getSelesaiTayang());
        schedules.setHarga(scheduleDto.getHarga());
        schedules.setFilms(scheduleDto.getFilms());

        return scheduleRepo.save(schedules);
    }

}
