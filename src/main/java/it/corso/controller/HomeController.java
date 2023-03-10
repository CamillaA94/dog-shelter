package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.service.CaneService;

@Controller
@RequestMapping(path = {"/", "/home"})
public class HomeController {

	@Autowired
    private CaneService caneService;
    
    @GetMapping
    public String getPage(Model model) {
    	model.addAttribute("titolo", "Amici a 4 zampe");
        model.addAttribute("cani", caneService.getCaniUltimi());
        return "home";
    }
}
