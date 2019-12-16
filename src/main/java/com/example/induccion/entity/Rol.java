package com.example.induccion.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "roles")
public class Rol {

	@Id
	@Column(name = "id", length = 15)
	private String id;

	@Column(name = "descripcion", length = 20, nullable = false)
	private String descripcion;

	@JsonIgnoreProperties("usuarioList")
	@ManyToMany(mappedBy = "rolList")
	private List<Usuario> usuarioList;

	public Rol() {
	}

	public Rol(String id) {
		this.id = id;
	}

	public Rol(String id, String descripcion, List<Usuario> usuarioList) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.usuarioList = usuarioList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	};
}
