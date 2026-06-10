package br.com.ClickParecer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ClickParecer.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{
    
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

}
