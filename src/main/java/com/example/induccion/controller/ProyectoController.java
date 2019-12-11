package com.example.induccion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.induccion.entity.Proyecto;
import com.example.induccion.repository.ProyectoRepository;

@RestController
public class ProyectoController {
	@Autowired
    private ProyectoRepository proyectoRepository;
	
	@GetMapping("/proyectos")
    public Page<Proyecto> getUsuarios(Pageable pageable) {
        return proyectoRepository.findAll(pageable);
    }
	
	@PostMapping("/proyectos")
    public Proyecto createUsuarios(@Valid @RequestBody Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }
}
