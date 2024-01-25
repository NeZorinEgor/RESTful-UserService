package ru.neZorinEgor.userService.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.neZorinEgor.userService.dto.UserDTO;
import ru.neZorinEgor.userService.model.User;
import ru.neZorinEgor.userService.service.UserService;
import ru.neZorinEgor.userService.util.UserErrorResponse;
import ru.neZorinEgor.userService.util.UserNotFoundedException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController{
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper){
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<UserDTO> allUsers(){
        return convertToListDTO(userService.allUsers());
    }



    @PostMapping
    public String saveUser(@RequestBody UserDTO userDTO){
        userService.saveUser(convertToUser(userDTO));
        return "User successful save";
    }

    @GetMapping("/{id}")
    public UserDTO findUserByProfNumber(@PathVariable("id") long profNumber){
        return convertToUserDTO(userService.findByProfNumber(profNumber));
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
        return modelMapper.map(userDTO, User.class);
    }

    private UserDTO convertToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    private List<UserDTO> convertToListDTO(List<User> users) {
        List<UserDTO> usersDTOS = new ArrayList<>();
        for (User user : users){
            usersDTOS.add(modelMapper.map(user, UserDTO.class));
        }
        return usersDTOS;
    }
}