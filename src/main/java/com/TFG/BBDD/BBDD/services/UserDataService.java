package com.TFG.BBDD.BBDD.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserDataService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveUserData(String name, String email, String option) {
        ZonedDateTime date = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = date.format(formatter);
        String sql = "INSERT INTO user (name, email, date, `option`) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, email, formattedDate, option);
    }
}
