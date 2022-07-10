package com.challange_4.apichallange4.Service;

import com.challange_4.apichallange4.Dto.CostumerDto;
import com.challange_4.apichallange4.Entity.Costumer;
import com.challange_4.apichallange4.Repository.CostumerRepo;
import com.challange_4.apichallange4.Repository.UsersRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //depedency injection : memberi tahu spring boot bahwa kalau ini class service
public class CostumerService {
    @Autowired // untuk mengimport suatu class, ga perlu instance kayak di native
    CostumerRepo usersRepo;
    @Autowired
    UsersRepo2 usersRepo2;

    public boolean save_users(CostumerDto usersDto) {
        Costumer users = new Costumer();

        users.setIdUsers(usersDto.getIdUsers());
        users.setUsername(usersDto.getUsername());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());
        usersRepo.save(users);
        return true;
    }

    public List<Costumer> users_display() {
        return usersRepo.findAll();
    }

    public List<Costumer> users_display_byID(int id_users) {
        return usersRepo.findByIdUsers(id_users);
    }

    public void users_delete_byID(int id_users) {
        Costumer delete = usersRepo2.findByIdUsers(id_users);
        if (delete != null) {
            usersRepo.deleteById(id_users);
        }
    }

    public void users_update_byID(int id, CostumerDto usersDto) throws Exception {
        Costumer update = usersRepo2.findByIdUsers(id);
        if (update != null) {
            update.setUsername(usersDto.getUsername());
            update.setEmail(usersDto.getEmail());
            update.setPassword(usersDto.getPassword());
            Costumer usersUpdate = usersRepo2.save(update);
        }
    }
}
