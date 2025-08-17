package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  // Utilise @Controller pour supporter les templates
public class HelloController {

    // ========== PAGES AVEC TEMPLATES HTML ==========
    
    @GetMapping("/")
    public String accueil() {
        return "index";  // Retourne le template index.html
    }

    @GetMapping("/formulaire")
    public String formulaire() {
        return "formulaire";  // Retourne le template formulaire.html
    }

    @PostMapping("/saluer")
    public String saluer(@RequestParam(value = "nom") String nom, Model model) {
        model.addAttribute("nom", nom);
        return "resultat";  // Retourne le template resultat.html
    }

    // ========== API ENDPOINTS (JSON/TEXT) ==========
    
    @GetMapping("/api/bonjour")
    @ResponseBody  // Important : force le retour de texte brut
    public String bonjourApi(@RequestParam(value = "nom", defaultValue = "Monde") String nom) {
        return "Bonjour " + nom + " !";
    }

    @GetMapping("/api/info")
    @ResponseBody  // Important : force le retour de texte brut
    public String infoApi() {
        return "Application Spring Boot - Version minimale créée à la main !";
    }
    
    // Pour la compatibilité avec vos anciens liens
    @GetMapping("/bonjour")
    @ResponseBody  // Important : force le retour de texte brut
    public String bonjour(@RequestParam(value = "nom", defaultValue = "Monde") String nom) {
        return "Bonjour " + nom + " !";
    }

    @GetMapping("/info")
    @ResponseBody  // Important : force le retour de texte brut
    public String info() {
        return "Application Spring Boot - Version minimale créée à la main !";
    }
}