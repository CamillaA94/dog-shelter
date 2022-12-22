package it.corso.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.service.AdminService;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AdminService adminService;
    
    @GetMapping
    public String getPage(@RequestParam(name = "er", required = false) String er, Model model) {
        boolean errore = er != null;
        model.addAttribute("titolo", "Login");
        model.addAttribute("errore", errore);
        return "log";
    }
    
    @PostMapping
    public String login(
            @RequestParam(name = "username", required = false) String username, 
            @RequestParam(name = "password", required = false) String password,  
            HttpSession session, 
            Model model) {
        if(session.getAttribute("logged") != null)
            return "redirect:/reserved";
        if(!adminService.login(username, password, session))
            return "redirect:/login?er";
        return "redirect:/riservata";
    }
}
