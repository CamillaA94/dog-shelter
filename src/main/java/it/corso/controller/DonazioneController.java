package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donazione")
public class DonazioneController {

    @GetMapping
    public String getPage() {
        return "donazione";
    }
}
