package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.service.AdminService;


import java.security.Principal;

@Controller
public class UserController {

    private final AdminService adminService;
@Autowired
    public UserController(AdminService adminService) {
        this.adminService = adminService;
    }
@GetMapping("/user")
    public String showUser(Model model, Principal principal){
    model.addAttribute("user", adminService.getUserByName(principal.getName()));
    return "user";
}
}
