package it.corso.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Cane;
import it.corso.service.CaneService;

@Controller
@RequestMapping("/adozioni")
public class AdozioniController {

	@Autowired
	private CaneService caneService;
    
    @GetMapping
    public String getPage(Model model, HttpSession session, @RequestParam(name = "ord", required = false) String ord) {
		List<Cane> cani = new ArrayList<Cane>();
		if(ord == null || ord.equals("alfabetico")) {
			cani = caneService.getCaniAlfabetico();
		} else if(ord.equals("ultimi")) {
			cani = caneService.getCaniUltimi();
		} else if(ord.equals("primi")) {
			cani = caneService.getCaniPrimi();
		} else if(ord.equals("crescente")) {
			cani = caneService.getCaniEtaCrescente();
		} else if(ord.equals("decrescente")) {
			cani = caneService.getCaniEtaDecrescente();
		} else if(ord.equals("femmine")) {
			cani = caneService.getCaniFemmine();
		} else if(ord.equals("maschi")) {
			cani = caneService.getCaniMaschi();
		}
		String ordine;
		if (ord == null) {
			ordine = "alfabetico";
		} else {
			ordine = ord;
		}
    	model.addAttribute("titolo", "Adozioni");
		model.addAttribute("cani", cani);
		model.addAttribute("ordine", ordine);
		return "adozioni";
    }
    
    @PostMapping("/ordina")
	public String ordinaCani(@RequestParam("ordine") String ordine) {
		return "redirect:/adozioni?ord=" + ordine;
	}
}
