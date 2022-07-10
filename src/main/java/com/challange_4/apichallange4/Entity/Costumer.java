package com.challange_4.apichallange4.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity // mendeklarasikan sebagai Entity
@Table(name = "Users") // mendeklarasikan sebagai tabel, name = "namaTabel"
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Costumer {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private int idUsers;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

}
