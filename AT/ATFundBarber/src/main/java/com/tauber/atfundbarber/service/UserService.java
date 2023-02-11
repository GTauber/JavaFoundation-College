package com.tauber.atfundbarber.service;

import com.tauber.atfundbarber.model.entity.User;
import java.util.List;

public interface UserService {

    User saveNewUser(User user);
    List<User> getAllUsers();


}
