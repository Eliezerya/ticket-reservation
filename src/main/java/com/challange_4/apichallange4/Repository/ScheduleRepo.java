package com.challange_4.apichallange4.Repository;

import com.challange_4.apichallange4.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {
    public List<Schedule> findAll();
    public Schedule findByScheduleId(int id);
}
