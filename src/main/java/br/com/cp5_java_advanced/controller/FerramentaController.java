package br.com.cp5_java_advanced.controller;

import br.com.cp5_java_advanced.service.FerramentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ferramentas")
public class FerramentaController {

    @Autowired
    private FerramentaService ferramentaService;

    @GetMapping
    public String listarFerramentas(@RequestParam(required = false) String nome, @RequestParam(required = false) String categoria, Model model) {
        var ferramentas = ferramentaService.listarFerramentas(nome, categoria);
        var quantidade = ferramentaService.listarQuantidade();

        if (ferramentas.isEmpty()) {
            if ((nome == null || nome.isBlank()) && (categoria == null || categoria.isBlank())) {
                model.addAttribute("mensagemVazio", true);
            } else {
                model.addAttribute("mensagemFiltro", true);
            }
        }

        model.addAttribute("ferramentas", ferramentas);
        model.addAttribute("quantidade", quantidade);

        return "ferramentas";
    }
}
