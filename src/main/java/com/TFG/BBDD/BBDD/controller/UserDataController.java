package com.TFG.BBDD.BBDD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TFG.BBDD.BBDD.services.UserDataService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserDataController {

    private final UserDataService userDataService;

    @Autowired
    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @PostMapping("/saveUserData")
    public String saveUserData(@RequestBody Map<String, String> userData) {
        String name = userData.get("name");
        String email = userData.get("email");
        String option = userData.get("option");

        // Parsear la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime date = LocalDateTime.parse(userData.get("date"), formatter);

        userDataService.saveUserData(name, email, option);

        return "Data saved successfully";
    }
}
