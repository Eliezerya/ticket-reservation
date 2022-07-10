package com.challange_4.apichallange4.Service;


import com.challange_4.apichallange4.Entity.User;

public interface UserLoginService {
    public User findByUsername(String username);
    public User saveUser(User user);
}