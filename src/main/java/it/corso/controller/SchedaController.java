package it.corso.controller;
import java.io.File;
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
@RequestMapping("/scheda")
public class SchedaController {
    
    @Autowired
    private CaneService caneService;
    
    @GetMapping
    public String getPage(@RequestParam("id") Integer id, Model model, HttpSession session) {
    	if(id == null || id == 0) {
    		return "redirect:/adozioni";
    	}
    	Cane cane = caneService.getCaneById(id);
    	String rootDir = session.getServletContext().getRealPath("/");
		String filePath2 = rootDir + "static\\cani\\" + id + "b.png";
		File file2 = new File(filePath2);
		cane.setImmagine2(file2.exists());
		String filePath3 = rootDir + "static\\cani\\" + id + "c.png";
		File file3 = new File(filePath3);
		cane.setImmagine3(file3.exists());
    	model.addAttribute("titolo", caneService.getCaneById(id).getNome());
        model.addAttribute("caneScheda", cane);
        model.addAttribute("cani", caneService.getCaniPrimi());
        return "scheda";
    }
}
