package com.berkcode.springbootblogwebapp.service;

import com.berkcode.springbootblogwebapp.dto.RegistrationDto;
import com.berkcode.springbootblogwebapp.entity.User;

public interface UserService {

    void saveUser(RegistrationDto registrationDto);

    User findByEmail(String email);
}
