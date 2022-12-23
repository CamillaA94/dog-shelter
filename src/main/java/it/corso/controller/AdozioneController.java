package it.corso.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Cane;
import it.corso.service.CaneService;

@Controller
@RequestMapping("/adozione")
public class AdozioneController {

 private CaneService caneService;
    
    @GetMapping
    public String getPage(Model model, @RequestParam(name = "ordine", required = false) String ordine) {
    	List<Cane> cani = new ArrayList<Cane>();
    	if(ordine.equals("alfabetico")) {
    		cani = caneService.getCaniAlfabetico();
    	} else if(ordine.equals("primi")) {
    		cani = caneService.getCaniPrimi();
    	} else if(ordine.equals("crescente")) {
    		cani = caneService.getCaniEtaCrescente();
    	} else if(ordine.equals("decrescente")) {
    		cani = caneService.getCaniEtaDecrescente();
    	} else if(ordine.equals("maschi")) {
    		cani = caneService.getCaniMaschi();
    	} else if(ordine.equals("femmine")) {
    		cani = caneService.getCaniFemmine();
    	} else {
    		cani = caneService.getCaniUltimi();
    	}
    	model.addAttribute("titolo", "Adozione");
        model.addAttribute("cani", cani);
        return "adozione";
    }
}
