package ru.spring.user.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.spring.user.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    User saveUser(User user);
    User findByProfNumber(long numeric);
    User updateUser(User user);
    void deleteUser(long profNumber);

}
