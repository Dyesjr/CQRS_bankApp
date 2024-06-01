package com.dyes.onlinebankingsystem.service.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserCommand {


    private String name;
    private String email;
    private String password;
}
