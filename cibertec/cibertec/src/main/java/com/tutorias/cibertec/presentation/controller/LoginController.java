package com.tutorias.cibertec.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("redirect:/find");
    }
}
