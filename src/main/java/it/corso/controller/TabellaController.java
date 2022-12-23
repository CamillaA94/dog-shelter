package it.corso.controller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.model.Cane;
import it.corso.service.CaneService;

@Controller
@RequestMapping("/tabella")
public class TabellaController {

	@Autowired
	private CaneService caneService;
	
	@GetMapping
	public String getPage(Model model, HttpSession session, @RequestParam(name = "ordine", required = false) String ordine) {
		if(session.getAttribute("logged") == null)
			return "redirect:/login";
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
		model.addAttribute("titolo", "Area riservata");
		model.addAttribute("cani", cani);
		return "tabella";
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
		return "redirect:/tabella";
	}
}
