package com.example.induccion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tareas")
public class Tarea extends Audit implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "descripcion", nullable = false, length = 300)
	private String descripcion;
	
	@Column(name = "alias", nullable = false, length = 50)
	private String alias;
	
	@Column(name = "estado", nullable = false)
	private boolean estado;
	
	@Column(name = "eliminado", nullable = false)
	private boolean eliminado;
	
	@Column(name = "fecha_inicio", nullable = true)
    private Date fechaInicio;
	
	@Column(name = "fecha_fin", nullable = true)
    private Date fechaFin;
    
    @ManyToOne
   	@JoinColumn(name = "id_proyecto", referencedColumnName = "id")
   	private Proyecto proyecto;
    
    @ManyToMany(mappedBy = "tareaList")
	private List<Usuario> usuarioList;

	public Tarea() {
	}

	public Tarea(Integer id, String nombre, String descripcion, String alias, boolean estado, boolean eliminado,
			Date fechaInicio, Date fechaFin, Proyecto proyecto, List<Usuario> usuarioList) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.alias = alias;
		this.estado = estado;
		this.eliminado = eliminado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.usuarioList = usuarioList;
		this.proyecto = proyecto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
}
