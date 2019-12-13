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
import com.example.induccion.entity.Tarea;
import com.example.induccion.repository.TareaRepository;

@RestController
@RequestMapping({"/tareas"})
public class TareaController {
	@Autowired
    private TareaRepository tareaRepository;
	
	@GetMapping
    public Page<Tarea> getUsuarios(Pageable pageable) {
        return tareaRepository.findAll(pageable);
    }
	
	@PostMapping
    public Tarea createUsuarios(@Valid @RequestBody Tarea tarea) {
		tarea.setEstado(true);
        return tareaRepository.save(tarea);
    }
	
	@GetMapping(path = {"/{id}"})
    public Tarea findOne(@PathVariable("id") int id){
        return tareaRepository.findById(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Tarea tarea){
    	Tarea foundTarea = tareaRepository.findById(tarea.getId());
    	if (foundTarea != null) {
    		tareaRepository.save(tarea);
    		return new ResponseEntity<Tarea>(tarea, HttpStatus.ACCEPTED);
    	}
    	
    	return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path ={"/{id}"})
    public Tarea delete(@PathVariable("id") int id) {
    	Tarea tarea = tareaRepository.findById(id);
        if(tarea != null){
        	Hibernate.initialize(tarea.getProyectoList());
        	Hibernate.initialize(tarea.getUsuarioList());
        	tareaRepository.delete(tarea);
        }
        return tarea;
    }
}
