package com.example.induccion.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.induccion.entity.Rol;
import com.example.induccion.entity.Usuario;
import com.example.induccion.repository.UsuarioRepository;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@GetMapping
    public Page<Usuario> getUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }
	
	@PostMapping
	public ResponseEntity<?> createUsuarios(@Valid @RequestBody Usuario usuario) {	
		usuario.setEstado(true);
		if (usuario.getRolList() == null) {
			usuario.setRolList(new ArrayList<Rol>());
			usuario.getRolList().add(new Rol("USER"));			
		}
		usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}
	
	@GetMapping(path = {"/{id}"})
    public Usuario findOne(@PathVariable("id") int id){
        return usuarioRepository.findById(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Usuario usuario){
    	Usuario foundUsuario = usuarioRepository.findById(usuario.getId());
    	if (foundUsuario != null) {
    		usuarioRepository.save(usuario);
    		return new ResponseEntity<Usuario>(usuario, HttpStatus.ACCEPTED);
    	}
    	
    	return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path ={"/{id}"})
    public Usuario delete(@PathVariable("id") int id) {
    	Usuario usuario = usuarioRepository.findById(id);
        if(usuario != null){
        	Hibernate.initialize(usuario.getProyectoList());
        	usuarioRepository.delete(usuario);
        }
        return usuario;
    }
}
