package com.example.travelfun.controller;

import com.example.travelfun.dtos.request.ApiResponse;
import com.example.travelfun.dtos.request.user.UserCreationRequest;
import com.example.travelfun.dtos.request.user.UserUpdateRequest;
import com.example.travelfun.entity.User;
import com.example.travelfun.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travelFun/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    ApiResponse<User>  createUser(@RequestBody @Valid  UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
       return apiResponse;
    }
    @GetMapping
    List<User> getAllUsers() {
       return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("edit/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
       return userService.updateUser(userId,request);
    }

    @DeleteMapping("delete/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
