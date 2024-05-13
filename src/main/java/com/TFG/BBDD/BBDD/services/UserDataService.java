package com.TFG.BBDD.BBDD.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveUserData(String name, String email, String date, String option) {
        String sql = "INSERT INTO user (name, email, date, `option`) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, email, date, option);
    }
}

