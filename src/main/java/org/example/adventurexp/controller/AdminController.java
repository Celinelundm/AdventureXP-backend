package com.example.adventurexp.controller;

import com.example.adventurexp.model.Admin;
import com.example.adventurexp.repository.AdminRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Optional<Admin> admin = adminRepository.findByUsernameAndPassword(username, password);

        if (admin.isPresent()) {
            return "Login successful!";
        } else {
            return "Invalid credentials.";
        }
    }
}
