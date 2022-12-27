package it.corso.controller;
import java.io.File;
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
@RequestMapping("/riservata")
public class RiservataController {

	@Autowired
	private CaneService caneService;
	
	@GetMapping
	public String getPage(Model model, HttpSession session, @RequestParam(name = "ord", required = false) String ord) {
		if(session.getAttribute("logged") == null)
			return "redirect:/login";
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
    	model.addAttribute("titolo", "Area riservata");
		model.addAttribute("cani", cani);
		model.addAttribute("ordine", ordine);
		return "riservata";
	}
	
	@GetMapping("/elimina")
	public String elimina(@RequestParam("id") Integer id, HttpSession session) {
		caneService.cancellaCane(caneService.getCaneById(id));
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\cani\\" + id + ".png";
		File file = new File(filePath);
		file.delete();
		String filePath2 = rootDir + "static\\cani\\" + id + "b.png";
		File file2 = new File(filePath2);
		if(file2.exists())
			file2.delete();
		String filePath3 = rootDir + "static\\cani\\" + id + "c.png";
		File file3 = new File(filePath3);
		if(file3.exists())
			file3.delete();
		return "redirect:/riservata";
	}
	
	@PostMapping("/ordina")
	public String ordinaCani(@RequestParam("ordine") String ordine) {
		return "redirect:/riservata?ord=" + ordine;
	}
}
