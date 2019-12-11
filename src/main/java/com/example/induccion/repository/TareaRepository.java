package com.example.induccion.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.induccion.entity.Tarea;

@Repository("tareaRepository")
public interface TareaRepository extends JpaRepository<Tarea, Serializable> {
	public abstract Tarea findByNombre(String nombre);
	public abstract List<Tarea> findAll();
	public abstract Tarea findById(Integer id);
}
