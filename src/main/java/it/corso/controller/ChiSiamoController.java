package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chiSiamo")
public class ChiSiamoController {

    @GetMapping
    public String getPage() {
        return "chiSiamo";
    }
}
