package br.com.cp5_java_advanced.config;


import br.com.cp5_java_advanced.service.UsuarioService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminInitializer {

    @Autowired
    private UsuarioService usuarioService;

    @PostConstruct
    public void init() {
        usuarioService.salvarAdminInicial();
    }
}
