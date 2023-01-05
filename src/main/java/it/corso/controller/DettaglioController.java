package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.service.CaneService;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {
    
    @Autowired
    private CaneService caneService;
    
    @GetMapping
    public String getPage(@RequestParam("id") Integer id, Model model) {
    	model.addAttribute("titolo", caneService.getCaneById(id).getNome());
        model.addAttribute("cane", caneService.getCaneById(id));
        model.addAttribute("cani", caneService.getCaniPrimi());
        return "dettaglio";
    }
}
