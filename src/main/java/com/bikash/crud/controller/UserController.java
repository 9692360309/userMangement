package com.bikash.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bikash.crud.entity.User;
import com.bikash.crud.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String viewUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user, Model model) {
        try {
            userService.createUser(user);
        } catch (Exception e) {
            model.addAttribute("error", "Failed to save user: " + e.getMessage());
            return "user-form";  // Return to form if error occurs
        }
        return "redirect:/users";
    }


    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
    
    @GetMapping("/toggleStatus/{id}")
    public String toggleUserStatus(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            // Toggle between Active and Inactive
            if (user.getStatus() == User.Status.Active) {
                user.setStatus(User.Status.Inactive);
            } else {
                user.setStatus(User.Status.Active);
            }
            userService.updateUser(user);  // Save updated status
        }
        return "redirect:/users";  // Redirect to the user list
    }

}
