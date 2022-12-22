package it.corso.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.service.CaneService;

@Controller
@RequestMapping("/adozione")
public class AdozioneController {

 private CaneService caneService;
    
    @GetMapping
    public String getPage(Model model) {
    	model.addAttribute("titolo", "Adozione");
        model.addAttribute("cani", caneService.getCaniUltimi());
        return "adozione";
    }
}
