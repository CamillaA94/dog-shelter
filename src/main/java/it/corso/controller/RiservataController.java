package it.corso.controller;
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
@RequestMapping("/riservata")
public class RiservataController {

	@Autowired
	private CaneService caneService;
	
	@GetMapping
	public String getPage(Model model, @RequestParam(name = "id", required = false) Integer id)
	{
		Cane cane = id != null && id != 0 ? caneService.getCaneById(id) : new Cane();
		if (cane.getVaccinazioni() == null) {
			cane.setVaccinazioni(" ");
			cane.setSesso(" ");
		}
		model.addAttribute("cane", cane);
		model.addAttribute("cani", caneService.getCani());
		return "riservata";
	}
	
	@PostMapping("/scelta")
	public String sceltaCane(@RequestParam("scelta") Integer id) {
		return "redirect:/riservata?id=" + id;
	}
	
	@PostMapping("/salva")
	public String salvaCane(
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam("nome") String nome,
			@RequestParam("razza") String razza,
			@RequestParam("eta") String eta,
			@RequestParam("sesso") String sesso,
			@RequestParam("sterilizzazione") boolean sterilizzazione,
			@RequestParam("vaccinazioni") String[] vax,
			@RequestParam("microchip") boolean microchip,
			@RequestParam("descrizione") String descrizione,
			@RequestParam("arrivo") String data)
	{
		if(!caneService.checkCane(nome,razza, descrizione))
			return "redirect:/riservata?errore";
		Cane cane = id != 0 ? caneService.getCaneById(id) : new Cane();
		caneService.registraCane(cane, id, nome, razza, eta, sesso, sterilizzazione, vax, microchip, descrizione, data);
		return "redirect:/riservata";
	}
	
	@GetMapping("/elimina")
	public String eliminaCane(@RequestParam("id") Integer id) {
		caneService.cancellaCane(caneService.getCaneById(id));
		return "redirect:/riservata";
	}
}
