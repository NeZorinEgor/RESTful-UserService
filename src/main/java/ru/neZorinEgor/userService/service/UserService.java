package ru.neZorinEgor.userService.service;

import ru.neZorinEgor.userService.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    User saveUser(User user);
    User findByProfNumber(long numeric);
    User updateUser(User user);
    void deleteUser(long profNumber);

}
