package ru.spring.user.service.implement;

import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.spring.user.model.User;
import ru.spring.user.repository.UserRepository;
import ru.spring.user.service.UserService;
import ru.spring.user.util.UserNotFoundedException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class UserServiceImpl implements UserService {
    private final UserRepository reposytory;

    public UserServiceImpl(UserRepository reposytory) {
        this.reposytory = reposytory;
    }

    @Override
    public List<User> allUsers() {
        return reposytory.findAll();
    }

    @Override
    public User saveUser(User user) {
        enrichUser(user);
        return reposytory.save(user);
    }

    @Override
    public User findByProfNumber(long numeric) {
        Optional<User> user = reposytory.findByProfNumber(numeric);
        return user.orElseThrow(UserNotFoundedException::new);
    }

    @Override
    public User updateUser(User user) {
        return reposytory.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(long profNumber) {
        reposytory.deleteByProfNumber(profNumber);
    }

    private void enrichUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setCreatedWho("ADIMN");
    }
}
