package it.corso.controller;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import it.corso.model.Cane;
import it.corso.service.CaneService;

@Controller
@RequestMapping("/riservata")
public class RiservataController {

	@Autowired
	private CaneService caneService;
	
	@GetMapping
	public String getPage(Model model, HttpSession session, @RequestParam(name = "id", required = false) Integer id)
	{
		if(session.getAttribute("logged") == null)
			return "redirect:/login";
		Cane cane = id != null && id != 0 ? caneService.getCaneById(id) : new Cane();
		if (cane.getVaccinazioni() == null) {
			cane.setVaccinazioni(" ");
			cane.setSesso(" ");
		}
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\cani\\" + id + ".png";
		File file = new File(filePath);
		cane.setImmagine(file.exists());
		String filePath2 = rootDir + "static\\cani\\" + id + "b.png";
		File file2 = new File(filePath2);
		cane.setImmagine2(file2.exists());
		String filePath3 = rootDir + "static\\cani\\" + id + "c.png";
		File file3 = new File(filePath3);
		cane.setImmagine3(file3.exists());
		model.addAttribute("titolo", "Area riservata");
		model.addAttribute("cane", cane);
		model.addAttribute("cani", caneService.getCaniAlfabetico());
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
			@RequestParam("arrivo") String data,
			@RequestParam(name = "immagine", required = false) MultipartFile immagine,
			@RequestParam(name = "immagine2", required = false) MultipartFile immagine2,
			@RequestParam(name = "immagine3", required = false) MultipartFile immagine3,
			HttpSession session)
	{
		if(!caneService.checkCane(nome, razza, descrizione))
			return "redirect:/riservata?er";
		Cane cane = id != 0 ? caneService.getCaneById(id) : new Cane();
		caneService.registraCane(cane, id, nome, razza, eta, sesso, sterilizzazione, vax, microchip, descrizione, data);
		if(!immagine.isEmpty())
			salvaImmagine(cane.getId(), immagine, session);
		if(immagine2 != null && !immagine2.isEmpty())
			salvaImmagine2(cane.getId(), immagine2, session);
		if(immagine3 != null && !immagine3.isEmpty())
			salvaImmagine3(cane.getId(), immagine3, session);
		return "redirect:/riservata";
	}
	
	@GetMapping("/elimina")
	public String eliminaCane(@RequestParam("id") Integer id, HttpSession session) {
		caneService.cancellaCane(caneService.getCaneById(id));
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\cani\\" + id + ".png";
		File file = new File(filePath);
		file.delete();
		return "redirect:/riservata";
	}
	
	@GetMapping("/eliminaimmagine2")
	public String eliminaImmagine2(@RequestParam("id") Integer id, HttpSession session) {
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\cani\\" + id + "b.png";
		File file = new File(filePath);
		file.delete();
		return "redirect:/riservata?id=" + id;
	}
	
	@GetMapping("/eliminaimmagine3")
	public String eliminaImmagine3(@RequestParam("id") Integer id, HttpSession session) {
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\cani\\" + id + "c.png";
		File file = new File(filePath);
		file.delete();
		return "redirect:/riservata?id=" + id;
	}
	
	private void salvaImmagine(int id, MultipartFile immagine, HttpSession session) {
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\cani\\" + id + ".png";
		try
		{
			immagine.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void salvaImmagine2(int id, MultipartFile immagine2, HttpSession session) {
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\cani\\" + id + "b.png";
		try
		{
			immagine2.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void salvaImmagine3(int id, MultipartFile immagine3, HttpSession session) {
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\cani\\" + id + "c.png";
		try
		{
			immagine3.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e)
		{
			e.printStackTrace();
		}
	}
}
