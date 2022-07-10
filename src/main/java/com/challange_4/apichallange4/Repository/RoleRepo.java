package com.challange_4.apichallange4.Repository;


import com.challange_4.apichallange4.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer> {

}
