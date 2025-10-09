package br.com.cp5_java_advanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PaginaInicialController {

    @GetMapping
    public String paginaInicial() {
        return "index";
    }
}
