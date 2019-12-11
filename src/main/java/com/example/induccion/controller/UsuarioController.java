package com.example.induccion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.induccion.entity.Usuario;
import com.example.induccion.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
    public Page<Usuario> getUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }
	
	@PostMapping("/usuarios")
    public Usuario createUsuarios(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
