package com.tauber.atfundbarber.service;

import com.tauber.atfundbarber.model.entity.DTO.UserDto;
import com.tauber.atfundbarber.model.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    User saveNewUser(User user);

    Optional<User> getUserByUserName(String userName);
    List<User> getAllUsers();
    Optional<User> validateUser(UserDto userDto);

    void deleteUser(User user);

    Optional<User> getUserById(UUID uuid);

    User getUserList(int index);
}
