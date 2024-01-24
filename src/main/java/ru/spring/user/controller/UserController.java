package ru.spring.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spring.user.dto.UserDTO;
import ru.spring.user.model.User;
import ru.spring.user.service.UserService;
import ru.spring.user.util.UserErrorResponse;
import ru.spring.user.util.UserNotFoundedException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> allUsers(){
        return userService.allUsers();
    }

    @PostMapping
    public User saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(convertToUser(userDTO));
    }

    @GetMapping("/{id}")
    public User findUserByProfNumber(@PathVariable("id") long profNumber){
        return userService.findByProfNumber(profNumber);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long profNumber){
        userService.deleteUser(profNumber);
        return "user successfully deleted";
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> handleException(UserNotFoundedException e){
        UserErrorResponse response = new UserErrorResponse(HttpStatus.NOT_FOUND,
                "User with this id not found!",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    private User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPatronymic(userDTO.getPatronymic());
        user.setPhone(userDTO.getPhone());
        user.setProfNumber(userDTO.getProfNumber());
        user.setFaculty(userDTO.getFaculty());
        user.setCourse(userDTO.getCourse());
        return user;
    }



}
