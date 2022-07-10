package com.challange_4.apichallange4.Repository;

import com.challange_4.apichallange4.Entity.MasterSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MasterSeatsRepo extends JpaRepository<MasterSeats, Integer> {
    public List<MasterSeats> findByStatus(boolean status); // mencari kursi yng masih tersedia
    public MasterSeats findByIdStudio(int idSStudio); // update status kursi
}
