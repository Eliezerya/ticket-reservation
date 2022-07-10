package com.challange_4.apichallange4.Service;

import com.challange_4.apichallange4.Dto.SeatDto;
import com.challange_4.apichallange4.Entity.MasterSeats;
import com.challange_4.apichallange4.Entity.Seat;
import com.challange_4.apichallange4.Repository.MasterSeatsRepo;
import com.challange_4.apichallange4.Repository.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SeatService {
    @Autowired
    SeatRepo seatsRepo;
    @Autowired
    MasterSeatsService masterSeatsService;
    @Autowired
    MasterSeatsRepo masterSeatsRepo;
    public Seat seats_submit(SeatDto seatsDto){

        Seat seats = new Seat();

        MasterSeats updateSeats = masterSeatsRepo.findByIdStudio(seatsDto.getDetailSeat().getIdStudio());
        seatsDto.getDetailSeat().setNoSeat(updateSeats.getNoSeat());
        seatsDto.getDetailSeat().setStudio(updateSeats.studio);

        // Submit seatsS
        seats.setSeatsId(seatsDto.getSeatsId());
        seats.setNameStudio(updateSeats.getStudio());
        seats.setNoKursi(updateSeats.getNoSeat());

        return seatsRepo.save(seats);

    }
}
