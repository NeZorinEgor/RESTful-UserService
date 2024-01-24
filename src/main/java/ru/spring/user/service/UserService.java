package ru.spring.user.service;

import ru.spring.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> allUsers();
    User saveUser(User user);
    User findByProfNumber(long numeric);
    User updateUser(User user);
    void deleteUser(long profNumber);

}
