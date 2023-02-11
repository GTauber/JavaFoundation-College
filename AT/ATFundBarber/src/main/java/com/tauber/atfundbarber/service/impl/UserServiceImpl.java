package com.tauber.atfundbarber.service.impl;

import com.tauber.atfundbarber.model.entity.User;
import com.tauber.atfundbarber.repository.UserRepository;
import com.tauber.atfundbarber.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User saveNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
