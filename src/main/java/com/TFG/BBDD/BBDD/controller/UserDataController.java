package com.TFG.BBDD.BBDD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TFG.BBDD.BBDD.services.UserDataService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * Controlador para gestionar los datos de usuario.
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserDataController {

    private final UserDataService userDataService;

    /**
     * Constructor para inyectar el servicio UserDataService.
     * 
     * @param userDataService el servicio UserDataService
     */
    @Autowired
    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    /**
     * Endpoint para guardar los datos de usuario y la imagen seleccionada.
     * 
     * @param userData los datos del usuario y la imagen
     * @return mensaje de éxito
     */
    @PostMapping("/saveUserData")
    public String saveUserData(@RequestBody Map<String, String> userData) {
        String name = userData.get("name");
        String email = userData.get("email");
        String option = userData.get("option");
        String imageUrl = userData.get("imageUrl");

        // Parsear la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime date = LocalDateTime.parse(userData.get("date"), formatter);

        userDataService.saveUserData(name, email, option, imageUrl);

        return "Data saved successfully";
    }

    /**
     * Endpoint para obtener las imágenes guardadas del usuario.
     * 
     * @param email el correo electrónico del usuario
     * @return una lista de URLs de imágenes
     */
    @GetMapping("/getUserImages")
    public List<String> getUserImages(@RequestParam String email) {
        return userDataService.getUserImages(email);
    }

    /**
     * Endpoint para procesar el pago de las imágenes seleccionadas.
     * 
     * @param userData los datos del usuario
     * @return mensaje de éxito
     */
    @PostMapping("/payForImages")
    public String payForImages(@RequestBody Map<String, String> userData) {
        String email = userData.get("email");
        userDataService.payForImages(email);
        return "Images paid successfully";
    }

    @GetMapping("/getUserPaidImages")
    public List<String> getUserPaidImages(@RequestParam String email) {
        return userDataService.getUserPaidImages(email);
    }
}
