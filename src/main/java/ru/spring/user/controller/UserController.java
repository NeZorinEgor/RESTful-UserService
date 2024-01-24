package ru.spring.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spring.user.model.User;
import ru.spring.user.service.UserService;
import ru.spring.user.util.UserErrorResponse;
import ru.spring.user.util.UserNotFoundedException;

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
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
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

}
