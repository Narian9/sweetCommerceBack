package com.admonSC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //esta clase Platillo se convierte en una entidad de JPA para manejar una persistencia de datos (que esta informacion se quede guardada en una BD)

@Table(name="carrito")//espeficificamos el nombre de la tabla de MySQL a donde llega esta informacion


public class Carrito {
	@Id //especificamos que nuestra llave primaria es el campo id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//le indicamos a JAVA que vamos a utilizar una estratega de generacion de valores de identidad de la base de datos (para generar valores unicos e incrementables para nuestras llaves primarias)
	@Column(name = "id_Carrito", unique = true, nullable = false) //especificamos que el campo donde se aplica la estrategia de generacion de valores autoincrementables es una columna llamada id, unica y no nula
	

	
	//Atributos
	private Long id_Carrito;
	private Integer cantidad;
	
	
	

	//Constructor vacio
	public Carrito() {
		
	}//constructor vacio


	//Constructor
	public Carrito(Long id_Carrito, Integer cantidad) {
		this.id_Carrito = id_Carrito;
		this.cantidad = cantidad;
	}
	
	//Getter & Setters 
	
	public Long getId_Carrito() {
		return id_Carrito;
	}


	public void setId_Carrito(Long id_Carrito) {
		this.id_Carrito = id_Carrito;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	

	//toString
	
	@Override
	public String toString() {
		return "Carrito [id=" + id_Carrito + ", cantidad=" + cantidad + "]";
	}



}
