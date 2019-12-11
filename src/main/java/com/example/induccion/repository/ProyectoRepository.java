package com.example.induccion.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.induccion.entity.Proyecto;

@Repository("proyectoRepository")
public interface ProyectoRepository extends JpaRepository<Proyecto, Serializable>{
	public abstract Proyecto findByNombre(String nombre);
	public abstract List<Proyecto> findAll();
	public abstract Proyecto findById(Integer id);
}
