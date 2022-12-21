package it.corso.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.model.Cane;
import it.corso.service.CaneService;

@Controller
@RequestMapping("/adozione")
public class AdozioneController {

 private CaneService caneService;
    
    @GetMapping
    public String getPage(Model model) {
        List<Cane> cani = caneService.getCani();
        model.addAttribute("cani", cani);
        return "adozione";
    }
}
