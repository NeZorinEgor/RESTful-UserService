package ru.spring.user.repository;

import org.springframework.stereotype.Repository;
import ru.spring.user.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class MemoryUserDAO {
    private final List<User> USERS = new ArrayList<>();

    public List<User> allUsers() {
        return USERS;
    }

    public User saveUser(User user) {
        USERS.add(user);
        return user;
    }

    public User findByProfNumber(long profNumber) {
        return USERS.stream().filter(user -> user.getProfNumber() == profNumber)
                .findAny()
                .orElse(null);
    }

    public User updateUser(User user) {
        int userIndex = IntStream.range(0, USERS.size())
                .filter(index -> USERS.get(index).getProfNumber() == user.getProfNumber())
                .findAny().orElse(-1);
        if (userIndex > -1){
            USERS.set(userIndex, user);
            return user;
        }
        return null;
    }

    public void deleteUser(long profNumber) {
        var index = findByProfNumber(profNumber);
        if (index != null){
            USERS.remove(index);
        }

    }
}
