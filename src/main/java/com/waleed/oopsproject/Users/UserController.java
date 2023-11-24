package com.waleed.oopsproject.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/")
    public Iterable<UserModel> hello() {
        return userService.getAllUsers();
    }

    @PostMapping(path = "/")
    public UserModel addUser(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    @PostMapping(path = "/check")
    public Boolean checkUser(@RequestParam Long userId) {
        UserModel user = userService.getUserById(userId);
        return user != null;
    }
}
