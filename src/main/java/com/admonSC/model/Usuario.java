package com.admonSC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")


public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)

	
	//Atribututos
private Long id;
private String nombre_Usuario;
private String apellido_Usuario;
private String correo_Usuario;
private String password_Usuario;
private String direccion_Usuario;
private Boolean es_Admin;


//Constructor vacio
public Usuario() {
	
}


//Constructor
public Usuario(Long id, String nombreUsuario, String apellidoUsuario, String correoUsuario, String passwordUsuario,
		String direccionUsuario, Boolean esAdmin) {
	this.id = id;
	this.nombre_Usuario = nombreUsuario;
	this.apellido_Usuario = apellidoUsuario;
	this.correo_Usuario = correoUsuario;
	this.password_Usuario = passwordUsuario;
	this.direccion_Usuario = direccionUsuario;
	this.es_Admin = esAdmin;
}

public Long getId() {
	return id;
}

public String getNombre_Usuario() {
	return nombre_Usuario;
}

public void setNombre_Usuario(String nombreUsuario) {
	this.nombre_Usuario = nombreUsuario;
}

public String getApellido_Usuario() {
	return apellido_Usuario;
}

public void setApellido_Usuario(String apellidoUsuario) {
	this.apellido_Usuario = apellidoUsuario;
}

public String getCorreo_Usuario() {
	return correo_Usuario;
}

public void setCorreo_Usuario(String correoUsuario) {
	this.correo_Usuario = correoUsuario;
}

public String getPassword_Usuario() {
	return password_Usuario;
}

public void setPassword_Usuario(String passwordUsuario) {
	this.password_Usuario = passwordUsuario;
}

public String getDireccion_Usuario() {
	return direccion_Usuario;
}

public void setDireccion_Usuario(String direccionUsuario) {
	this.direccion_Usuario = direccionUsuario;
}

public Boolean getEs_Admin() {
	return es_Admin;
}

public void setEs_Admin(Boolean esAdmin) {
	this.es_Admin = esAdmin;
}

@Override
public String toString() {
	return "Usuario [id=" + id + ", nombreUsuario=" + nombre_Usuario + ", apellidoUsuario=" + apellido_Usuario
			+ ", correoUsuario=" + correo_Usuario + ", passwordUsuario=" + password_Usuario + ", direccionUsuario="
			+ direccion_Usuario + ", esAdmin=" + es_Admin + "]";
}
}
