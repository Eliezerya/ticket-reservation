package com.challange_4.apichallange4.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CostumerDto {
    private int idUsers;
    private String username;
    private String email;
    private String password;
}
