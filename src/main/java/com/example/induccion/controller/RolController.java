package com.example.induccion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.induccion.entity.Rol;
import com.example.induccion.entity.Usuario;
import com.example.induccion.repository.RolRepository;
import com.example.induccion.repository.UsuarioRepository;

@RestController
@RequestMapping({"/roles"})
public class RolController {
	@Autowired
    private RolRepository rolRepository;
	
	@GetMapping
    public Page<Rol> getRoles(Pageable pageable) {
        return rolRepository.findAll(pageable);
    }

}
