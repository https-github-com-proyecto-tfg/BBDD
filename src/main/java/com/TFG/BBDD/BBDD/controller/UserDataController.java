package com.TFG.BBDD.BBDD.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TFG.BBDD.BBDD.services.UserDataService;

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
        String date = userData.get("date");
        String option = userData.get("option");

        userDataService.saveUserData(name, email, date, option);

        return "Data saved successfully";
    }
}

