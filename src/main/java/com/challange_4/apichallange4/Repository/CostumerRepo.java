package com.challange_4.apichallange4.Repository;

import com.challange_4.apichallange4.Entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

// Pengoperasian DB, Select, save, update, delete
// untuk sintaks Query DB
// T : Tabel , ID : tipe data primary key di table
@Transactional // untuk rollback value jika terjadi error
@Repository //menandakan kalau repository
public interface CostumerRepo extends JpaRepository<Costumer, Integer> {
    List<Costumer> findAll();
    public List<Costumer> findByIdUsers(int id);
}
