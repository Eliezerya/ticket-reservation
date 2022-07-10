package com.challange_4.apichallange4.Service;


import com.challange_4.apichallange4.Entity.MasterSeats;
import com.challange_4.apichallange4.Repository.MasterSeatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterSeatsService {
    @Autowired
    MasterSeatsRepo masterSeatsRepo;

    public List<MasterSeats> get_studioBy_status(boolean status) {
        return masterSeatsRepo.findByStatus(status);
    }

    public MasterSeats update_seats(int idStudio, boolean status) {
        MasterSeats masterSeats = masterSeatsRepo.findByIdStudio(idStudio);
        try {
            if (masterSeats != null) {
                masterSeats.setStatus(status);
                return masterSeatsRepo.save(masterSeats);
            }
        } catch (Exception e) {
            System.err.println("Data not found");
        }
        return masterSeats;
    }
}
