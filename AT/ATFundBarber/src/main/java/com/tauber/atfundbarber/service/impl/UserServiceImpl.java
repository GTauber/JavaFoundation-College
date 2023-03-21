package com.tauber.atfundbarber.service.impl;

import com.tauber.atfundbarber.model.entity.DTO.UserDto;
import com.tauber.atfundbarber.model.entity.User;
import com.tauber.atfundbarber.repository.UserRepository;
import com.tauber.atfundbarber.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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

    @Override
    public Optional<User> getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Optional<User> validateUser(UserDto userDto) {
        var user = userRepository.findByUserName(userDto.getUserName());
        if (user.isPresent() && user.get().getPassword().equals(userDto.getPassword())) return user;
        return Optional.empty();
    }

    @Override
    public void deleteUser(User user) {
         userRepository.delete(user);
    }

    @Override
    public Optional<User> getUserById(UUID uuid) {
        var user = userRepository.findById(uuid);
        if (user.isPresent()) return user;
        return Optional.empty();
    }

    @Override
    public User getUserList(int index) {
        return userRepository.findAll().get(index);
    }
}
