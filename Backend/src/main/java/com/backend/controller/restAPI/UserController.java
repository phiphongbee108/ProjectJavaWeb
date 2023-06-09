package com.backend.controller.restAPI;

import com.backend.models.User;
import com.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/be/")
public class UserController {

    @Autowired
    private UserService UserService;

    @PostMapping("/add-user")
    public Boolean createUser(@ModelAttribute User user) {
        UserService.createOrUpdateUser(user);
        return true;
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
    List<User> list = UserService.getAllUser();
    return list;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return UserService.getUser(id);
    }

    @DeleteMapping("/delete-user/{id}")
    public Boolean deleteUser(@PathVariable Long id) {
        UserService.deleteUser(id);
        return true;
    }

    @GetMapping("/edit-user/{id}")
    public User editUser(@PathVariable Long id) {
        return UserService.editUser(id);
    }

    @PutMapping("/update-user/{id}")
    public Boolean updateUser(@PathVariable Long id, @ModelAttribute User user) {
        User UserOrigin = UserService.getUser(id);
        UserOrigin.setpass(user.getpass());
        UserOrigin.setusername(user.getusername());
        UserOrigin.setRole_user(user.getRole_user());
        UserService.createOrUpdateUser(UserOrigin);
        return true;
    }
}
