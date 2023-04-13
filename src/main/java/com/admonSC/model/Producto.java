package com.admonSC.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //esta clase Platillo se convierte en una entidad de JPA para manejar una persistencia de datos (que esta informacion se quede guardada en una BD)

@Table(name="producto")//espeficificamos el nombre de la tabla de MySQL a donde llega esta informacion


public class Producto {
	@Id //especificamos que nuestra llave primaria es el campo id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//le indicamos a JAVA que vamos a utilizar una estratega de generacion de valores de identidad de la base de datos (para generar valores unicos e incrementables para nuestras llaves primarias)
	@Column(name = "id", unique = true, nullable = false) //especificamos que el campo donde se aplica la estrategia de generacion de valores autoincrementables es una columna llamada id, unica y no nula
	
//	@OneToOne()
//	@JoinTable(
//	    name = "wishlist",
//	    joinColumns = @JoinColumn(name = "id"),
//	    inverseJoinColumns = @JoinColumn(name = "id")
//	)
//	private Set<Producto> producto;
//
//	public Set<Producto> getProducto() {
//	  return producto;
//	}

	
	//Atributos
	private Long id;
	private String nombre_Producto;
	private Double precio;
	private Integer categoria;
	private Boolean popular;
	private Boolean nuevo;
	private Integer existencias;
	private String imagen_Src;
	
	

	//Constructor vacio
	public Producto() {
		
	}//constructor vacio


	//Constructor
	public Producto(Long id, String nombreProducto, Double precio, Integer categoria, Boolean popular, Boolean nuevo,
			Integer existencias, String imagenSrc) {
		this.id = id;
		this.nombre_Producto = nombreProducto;
		this.precio = precio;
		this.categoria = categoria;
		this.popular = popular;
		this.nuevo = nuevo;
		this.existencias = existencias;
		this.imagen_Src = imagenSrc;
	}
	
	//Getter & Setters 
	
	public Long getId() {
		return id;
	}

	public String getNombre_Producto() {
		return nombre_Producto;
	}


	public void setNombre_Producto(String nombreProducto) {
		this.nombre_Producto = nombreProducto;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public Integer getCategoria() {
		return categoria;
	}


	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}


	public Boolean getPopular() {
		return popular;
	}


	public void setPopular(Boolean popular) {
		this.popular = popular;
	}


	public Boolean getNuevo() {
		return nuevo;
	}


	public void setNuevo(Boolean nuevo) {
		this.nuevo = nuevo;
	}


	public Integer getExistencias() {
		return existencias;
	}


	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}


	public String getImagen_Src() {
		return imagen_Src;
	}


	public void setImagen_Src(String imagenSrc) {
		this.imagen_Src = imagenSrc;
	}

	//toString
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombreProducto=" + nombre_Producto + ", precio=" + precio + ", categoria="
				+ categoria + ", popular=" + popular + ", nuevo=" + nuevo + ", existencias=" + existencias
				+ ", imagenSrc=" + imagen_Src + "]";
	}
	
	
	
	
}
