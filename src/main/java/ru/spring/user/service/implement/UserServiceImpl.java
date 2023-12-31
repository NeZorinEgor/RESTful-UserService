package ru.spring.user.service.implement;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.spring.user.model.User;
import ru.spring.user.repository.UserReposytory;
import ru.spring.user.service.UserService;

import java.util.List;

@Service
@Primary
public class UserServiceImpl implements UserService {
    private final UserReposytory reposytory;

    public UserServiceImpl(UserReposytory reposytory) {
        this.reposytory = reposytory;
    }

    @Override
    public List<User> allUsers() {
        return reposytory.findAll();
    }

    @Override
    public User saveUser(User user) {
        return reposytory.save(user);
    }

    @Override
    public User findByProfNumber(long numeric) {
        return reposytory.findByProfNumber(numeric);
    }

    @Override
    public User updateUser(User user) {
        return reposytory.save(user);
    }

    @Override
    public void deleteUser(long profNumber) {
        reposytory.deleteByProfNumber(profNumber);
    }
}
