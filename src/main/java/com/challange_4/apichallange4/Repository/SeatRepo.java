package com.challange_4.apichallange4.Repository;

import com.challange_4.apichallange4.Entity.Seat;
import com.challange_4.apichallange4.Entity.SeatsPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SeatRepo extends JpaRepository<Seat, SeatsPk> {
    public List<Seat> findAll();
}
