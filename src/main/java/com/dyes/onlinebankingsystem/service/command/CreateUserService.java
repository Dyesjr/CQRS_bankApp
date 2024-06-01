package com.dyes.onlinebankingsystem.service.command;

import com.dyes.onlinebankingsystem.exceptions.UserAlreadyExistsException;
import com.dyes.onlinebankingsystem.interfaces.UserRepository;
import com.dyes.onlinebankingsystem.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CreateUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User handle(CreateUserCommand command) {
        if (userRepository.findByEmail(command.getEmail()).isPresent()){
            throw new UserAlreadyExistsException("Email already in use");
        }

        //hash the password
        String hashedPassword = passwordEncoder.encode(command.getPassword());

        //Create the user
        User user = User.builder()
                .name(command.getName())
                .email(command.getEmail())
                .password(command.getPassword())
                .build();

        //save the user
        return userRepository.save(user);
    }
}
