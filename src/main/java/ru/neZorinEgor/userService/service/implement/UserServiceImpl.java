package ru.neZorinEgor.userService.service.implement;

import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.neZorinEgor.userService.dto.UserDTO;
import ru.neZorinEgor.userService.model.User;
import ru.neZorinEgor.userService.repository.UserRepository;
import ru.neZorinEgor.userService.service.UserService;
import ru.neZorinEgor.userService.util.UserNotFoundedException;

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
        enrichOnCreateUser(user);
        return reposytory.save(user);
    }

    @Override
    public User findByProfNumber(long numeric) {
        Optional<User> user = reposytory.findByProfNumber(numeric);
        return user.orElseThrow(UserNotFoundedException::new);
    }

    @Override
    public User updateUser(User updatedUser) {
        User notDtoUser = findByProfNumber(updatedUser.getProfNumber());
        updatedUser.setId(notDtoUser.getId());
        updatedUser.setUpdatedAt(LocalDateTime.now());
        updatedUser.setCreatedAt(notDtoUser.getCreatedAt());
        updatedUser.setCreatedWho(notDtoUser.getCreatedWho());
        return reposytory.save(updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(long profNumber) {
        reposytory.deleteByProfNumber(profNumber);
    }

    private void enrichOnCreateUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(null);
        user.setCreatedWho("ADIMN");
    }
}
