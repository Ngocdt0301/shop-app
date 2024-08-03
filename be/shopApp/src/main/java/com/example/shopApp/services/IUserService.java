package com.example.shopApp.services;

import com.example.shopApp.dtos.UserDTO;
import com.example.shopApp.exceptions.DataNotFoundException;
import com.example.shopApp.models.User;

public interface IUserService {
    User createUser(UserDTO userDTO) throws DataNotFoundException;

    String login(String phoneNumber, String password);
}
