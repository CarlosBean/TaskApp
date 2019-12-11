package com.example.induccion.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "cedula", nullable = false, unique = true, length = 11)
	private String cedula;

	@Column(name = "password", nullable = false, length = 80)
	private String password;

	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;

	@Column(name = "email", nullable = false, unique = true, length = 80)
	private String email;

	@Column(name = "estado", nullable = true)
	private boolean estado;
	
	@Column(name = "eliminado", nullable = true)
	private boolean eliminado;
	
	@Column(name = "fecha_inicio", nullable = true)
    private Date fechaInicio;
	
	@Column(name = "fecha_fin", nullable = true)
    private Date fechaFin;
	
	@Column(name = "fecha_creacion", nullable = true, updatable = false)
    @CreatedDate
    private Date fechaCreacion;
	
    @Column(name = "fecha_actualizacion", nullable = true)
    @LastModifiedDate
    private Date fechaActualizacion;
    
    @JoinTable(name = "usuarios_has_roles", joinColumns = {
			@JoinColumn(name = "id_usuarios", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_roles", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Rol> rolList;
    
    @JoinTable(name = "usuarios_has_tareas", joinColumns = {
			@JoinColumn(name = "id_usuarios", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_tareas", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Tarea> tareaList;
    
    @ManyToMany(mappedBy = "usuarioList")
	private List<Proyecto> proyectoList;

	public Usuario() {
	}

	public Usuario(Integer id, String cedula, String password, String nombre, String email, boolean estado,
			boolean eliminado, Date fechaInicio, Date fechaFin, Date fechaCreacion, Date fechaActualizacion,
			List<Rol> rolList, List<Tarea> tareaList, List<Proyecto> proyectoList) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.password = password;
		this.nombre = nombre;
		this.email = email;
		this.estado = estado;
		this.eliminado = eliminado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.rolList = rolList;
		this.tareaList = tareaList;
		this.proyectoList = proyectoList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public List<Rol> getRolList() {
		return rolList;
	}

	public void setRolList(List<Rol> rolList) {
		this.rolList = rolList;
	}

	public List<Tarea> getTareaList() {
		return tareaList;
	}

	public void setTareaList(List<Tarea> tareaList) {
		this.tareaList = tareaList;
	}

	public List<Proyecto> getProyectoList() {
		return proyectoList;
	}

	public void setProyectoList(List<Proyecto> proyectoList) {
		this.proyectoList = proyectoList;
	}
}
