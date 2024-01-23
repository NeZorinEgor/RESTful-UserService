package ru.spring.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.user.model.User;

import java.util.Optional;

@Repository
public interface UserReposytory extends JpaRepository<User, Long> {
    Optional<User> findByProfNumber(long profNumber);
    void deleteByProfNumber(long profNumber);
}
