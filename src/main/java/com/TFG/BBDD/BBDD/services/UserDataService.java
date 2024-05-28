package com.TFG.BBDD.BBDD.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserDataService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveUserData(String name, String email, String option, String imageUrl) {
        ZonedDateTime date = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = date.format(formatter);
        String sql = "INSERT INTO user (name, email, date, `option`, image_url) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, email, formattedDate, option, imageUrl);
    }

    public List<String> getUserImages(String email) {
        String sql = "SELECT image_url FROM user WHERE email = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{email}, String.class);
    }

    public void payForImages(String email) {
        String sql = "UPDATE user SET estado = 'pagado' WHERE email = ? AND estado = 'pendiente'";
        jdbcTemplate.update(sql, email);
    }
}