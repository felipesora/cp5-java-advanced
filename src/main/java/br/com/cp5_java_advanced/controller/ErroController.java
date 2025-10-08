package br.com.cp5_java_advanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErroController {

    @GetMapping("/403")
    public String acessoNegado() {
        return "error/403";
    }
}

