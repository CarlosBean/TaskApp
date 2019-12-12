package com.example.induccion.controller;

import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.induccion.entity.Proyecto;
import com.example.induccion.repository.ProyectoRepository;

@RestController
@RequestMapping({"/proyectos"})
public class ProyectoController {
	@Autowired
    private ProyectoRepository proyectoRepository;
	
	@GetMapping
    public Page<Proyecto> getUsuarios(Pageable pageable) {
        return proyectoRepository.findAll(pageable);
    }
	
	@PostMapping
    public Proyecto createUsuarios(@Valid @RequestBody Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }
	
	@GetMapping(path = {"/{id}"})
    public Proyecto findOne(@PathVariable("id") int id){
        return proyectoRepository.findById(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Proyecto proyecto){
    	Proyecto foundProyecto = proyectoRepository.findById(proyecto.getId());
    	if (foundProyecto != null) {
    		proyectoRepository.save(proyecto);
    		return new ResponseEntity<Proyecto>(proyecto, HttpStatus.ACCEPTED);
    	}
    	
    	return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path ={"/{id}"})
    public Proyecto delete(@PathVariable("id") int id) {
    	Proyecto proyecto = proyectoRepository.findById(id);
        if(proyecto != null){
        	// Hibernate.initialize(proyecto.getProyectoList());
        	proyectoRepository.delete(proyecto);
        }
        return proyecto;
    }
}
