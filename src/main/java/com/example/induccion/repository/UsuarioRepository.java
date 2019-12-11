package com.example.induccion.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.induccion.entity.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
	public abstract Usuario findByCedula(String cedula);
	public abstract List<Usuario> findAll();
	public abstract Usuario findById(Integer id);
}
