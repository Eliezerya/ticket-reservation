package com.challange_4.apichallange4.Service;


import com.challange_4.apichallange4.Entity.ViewJadwalDetail;
import com.challange_4.apichallange4.Repository.ViewJadwalDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewJadwalDetailService {
    @Autowired
    ViewJadwalDetailRepo viewJadwalDetailRepo;

    public List<ViewJadwalDetail> display_all(){
        return viewJadwalDetailRepo.findAll();
    }
}
