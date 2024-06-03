package com.TFG.BBDD.BBDD.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Servicio para gestionar los datos de usuario en la base de datos.
 */
@Service
public class UserDataService {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor para inyectar el JdbcTemplate.
     * 
     * @param jdbcTemplate el JdbcTemplate
     */
    @Autowired
    public UserDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Guarda los datos del usuario y la imagen seleccionada en la base de datos.
     * 
     * @param name el nombre del usuario
     * @param email el correo electrónico del usuario
     * @param option la opción seleccionada
     * @param imageUrl la URL de la imagen seleccionada
     */
    public void saveUserData(String name, String email, String option, String imageUrl) {
        ZonedDateTime date = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = date.format(formatter);
        String sql = "INSERT INTO user (name, email, date, `option`, image_url) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, email, formattedDate, option, imageUrl);
    }

    /**
     * Obtiene las URLs de las imágenes guardadas por un usuario específico.
     * 
     * @param email el correo electrónico del usuario
     * @return una lista de URLs de imágenes
     */
    public List<String> getUserImages(String email) {
        String sql = "SELECT image_url FROM user WHERE email = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{email}, String.class);
    }

    /**
     * Marca las imágenes seleccionadas por un usuario como pagadas en la base de datos.
     * 
     * @param email el correo electrónico del usuario
     */
    public void payForImages(String email) {
        String sql = "UPDATE user SET estado = 'pagado' WHERE email = ? AND estado = 'pendiente'";
        jdbcTemplate.update(sql, email);
    }

    public List<String> getUserPaidImages(String email) {
        String sql = "SELECT image_url FROM user WHERE email = ? AND estado = 'pagado'";
        return jdbcTemplate.queryForList(sql, new Object[]{email}, String.class);
    }
}
