package com.sv.edu.udb.dss.sql_injection_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "state", required = false) String state, Model model) {
        System.out.println("[LOGIN PAGE] Cargando /login con state=" + state);

        if ("success".equals(state)) {
            model.addAttribute("message", "✅ Inicio de sesión exitoso");
        } else if ("failed".equals(state)) {
            model.addAttribute("message", "❌ Usuario o contraseña incorrectos");
        }

        return "login";
    }

    @PostMapping("/sendLogin")
    public String authenticateUser(@RequestParam String username, @RequestParam String password) {
        System.out.println("[AUTH] Se recibió POST /sendLogin");
        System.out.println("[AUTH] Usuario: " + username);
        System.out.println("[AUTH] Contraseña: " + password);

        // Consulta SQL básica (manteniendo la lógica sencilla)
        String query = "SELECT COUNT(*) FROM users WHERE username = '" + username + 
                    "' AND password = '" + password + "'";

        System.out.println("[QUERY] " + query);

        Integer count = jdbcTemplate.queryForObject(query, Integer.class);

        if (count != null && count > 0) {
            System.out.println("[AUTH] Credenciales válidas → redirigiendo a /login?state=success");
            return "redirect:/login?state=success";
        } else {
            System.out.println("[AUTH] Credenciales inválidas → redirigiendo a /login?state=failed");
            return "redirect:/login?state=failed";
        }
    }
}
