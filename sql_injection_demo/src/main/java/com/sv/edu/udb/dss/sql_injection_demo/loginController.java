package com.sv.edu.udb.dss.sql_injection_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Map;

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
    public String authenticateUser(@RequestParam String username,
                                @RequestParam String password,
                                RedirectAttributes redirectAttrs) {

        System.out.println("[AUTH] Se recibió POST /sendLogin");

        try {
            String query = "SELECT * FROM users WHERE username = '" + username +
                        "' AND password = '" + password + "'";
            System.out.println("[QUERY] " + query);

            List<Map<String, Object>> results = jdbcTemplate.queryForList(query);

            redirectAttrs.addFlashAttribute("dbQuery", query);
            redirectAttrs.addFlashAttribute("dbResult", results);

            if (!results.isEmpty()) {
                System.out.println("[AUTH] Credenciales válidas");
                return "redirect:/login?state=success";
            } else {
                System.out.println("[AUTH] Credenciales inválidas");
                return "redirect:/login?state=failed";
            }

        } catch (Exception ex) {
            System.out.println("[DB ERROR] " + ex.getMessage());
            redirectAttrs.addFlashAttribute("dbQuery", "Error ejecutando query");
            redirectAttrs.addFlashAttribute("dbResult", ex.getMessage());
            return "redirect:/login?state=dberror";
        }
    }
}