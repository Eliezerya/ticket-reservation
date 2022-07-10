package com.challange_4.apichallange4.Repository;

import com.challange_4.apichallange4.Entity.ViewJadwalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ViewJadwalDetailRepo extends JpaRepository<ViewJadwalDetail, Integer> {
    List<ViewJadwalDetail> findAll();
}
