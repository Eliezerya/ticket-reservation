package com.challange_4.apichallange4.Service;


import com.challange_4.apichallange4.Dto.CustomerOrderDto;
import com.challange_4.apichallange4.Entity.*;
import com.challange_4.apichallange4.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostumerOrderService {
    @Autowired
    CostumerOrderRepo costumerOrderRepo;
    @Autowired
    ScheduleRepo scheduleRepo;
    @Autowired
    FilmRepo2 filmsRepo2;
    @Autowired
    UsersRepo2 usersRepo2;
    @Autowired
    MasterSeatsService masterSeatsService;

    public void customer_save(CustomerOrderDto customerOrderDto) {
        CostumerOrder customerOrder = new CostumerOrder();
        try {
            Schedule schedules = scheduleRepo.findByScheduleId(customerOrderDto.getScheduleId());
            Film films = filmsRepo2.findById(customerOrderDto.getFilmCode());
            Costumer users = usersRepo2.findByIdUsers(customerOrderDto.getIdUser().getIdUsers());

            MasterSeats masterSeats = masterSeatsService.update_seats(customerOrderDto.getIdSeat(), customerOrderDto.isStatus());
            customerOrder.setIdSeat(customerOrderDto.getIdSeat());
            customerOrder.setFilmCode(customerOrderDto.getFilmCode());
            customerOrder.setScheduleId(customerOrderDto.getScheduleId());
            customerOrder.setIdUser(customerOrderDto.getIdUser());
            costumerOrderRepo.save(customerOrder);
        } catch (Exception e) {
            System.err.println("error");
        }
    }
}
