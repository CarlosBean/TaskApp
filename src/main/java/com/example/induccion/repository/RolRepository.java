package com.example.induccion.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.induccion.entity.Rol;

@Repository("rolRepository")
public interface RolRepository extends JpaRepository<Rol, Serializable>{
	public abstract Rol findByDescripcion(String descripcion);
	public abstract List<Rol> findAll();
	public abstract Rol findById(String id);
}
