package ru.neZorinEgor.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.neZorinEgor.userService.dto.UserDTO;
import ru.neZorinEgor.userService.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByProfNumber(long profNumber);
    void deleteByProfNumber(long profNumber);
}
