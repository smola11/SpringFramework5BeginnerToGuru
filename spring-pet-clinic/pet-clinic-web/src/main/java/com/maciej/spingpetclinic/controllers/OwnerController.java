package com.maciej.spingpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    @GetMapping({"", "/", "/index", "/index.html"})
    public String listVets() {
        return "owners/index";
    }
}
