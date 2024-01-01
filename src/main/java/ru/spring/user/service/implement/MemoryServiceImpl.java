package ru.spring.user.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.user.model.User;
import ru.spring.user.repository.MemoryUserDAO;
import ru.spring.user.service.UserService;

import java.util.List;

@Service
public class MemoryServiceImpl implements UserService {
    private final MemoryUserDAO repository;

    @Autowired
    public MemoryServiceImpl(MemoryUserDAO memoryUserDAO) {
        this.repository = memoryUserDAO;
    }

    @Override
    public List<User> allUsers() {
        return repository.allUsers();
    }

    @Override
    public User saveUser(User user) {
        return repository.saveUser(user);
    }

    @Override
    public User findByProfNumber(long profNumber) {
        return repository.findByProfNumber(profNumber);
    }

    @Override
    public User updateUser(User user) {
        return repository.updateUser(user);
    }

    @Override
    public void deleteUser(long profNumber) {
        repository.deleteUser(profNumber);
    }
}
