package com.challange_4.apichallange4.Repository;

import com.challange_4.apichallange4.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User,Integer> {
    public User findByUsername(String username);
    public User findByEmail(String email);
//    public User saveUser(User user);
}
