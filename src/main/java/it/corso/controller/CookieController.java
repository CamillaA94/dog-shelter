package it.corso.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController {

	@GetMapping
    public String getPage(Model model) {
    	model.addAttribute("titolo", "Cookie Policy");
        return "cookie";
    }
}
