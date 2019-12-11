package com.example.induccion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.induccion.entity.Tarea;
import com.example.induccion.repository.TareaRepository;

@RestController
public class TareaController {
	@Autowired
    private TareaRepository tareaRepository;
	
	@GetMapping("/tareas")
    public Page<Tarea> getUsuarios(Pageable pageable) {
        return tareaRepository.findAll(pageable);
    }
	
	@PostMapping("/tareas")
    public Tarea createUsuarios(@Valid @RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }
}
