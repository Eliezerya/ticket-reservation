package com.challange_4.apichallange4.Repository;

import com.challange_4.apichallange4.Entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UsersRepo2 extends JpaRepository<Costumer, Integer> {
    public Costumer findByIdUsers(int id_users);
}
