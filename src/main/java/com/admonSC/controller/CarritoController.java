package com.admonSC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admonSC.model.Carrito;
import com.admonSC.service.CarritoService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })

@RestController //anotacion para indicar que esta clase es un controlador

@RequestMapping(path = "/sweetCommerce/carrito/") //indica la ruta de nuestro endpoint par saber a donde se van a manejar esas solicitudes HTTP


public class CarritoController {

	//Inyeccion de dependencias
	private final CarritoService carritoService;

	@Autowired //anotacion para relacionar e inyectar dependencia 
	
	//Constructor que usa el objeto PlatilloService como parametro
	public CarritoController (CarritoService carritoService) {
		this.carritoService = carritoService;
	}//contructor
	

	
	//Solicitudes HTTP para traer todos los productos
	@GetMapping
	public List<Carrito> getCantidad(){
		return carritoService.leerCarrito();
	}
	
	//Solicitar HTTP para traer un producto por Id
	@GetMapping(path = "{Id}")
	//Con @PathVariable le digo a mi metodo, que la ruta que va a variar es el id, con el tipo de dato Long id

	public Carrito getCantidad(@PathVariable("Id")Long id_Carrito) {
		return carritoService.leerCarrito(id_Carrito);
	}
	
	
	//Solicitar HTTP para crear un producto
		@PostMapping
		public void postCarrito (@RequestBody Carrito carrito) { // Que los datos que pasemos como cuerpo de nuestra solicitud, seran utilizados como campos de nuestro constructor
			carritoService.crearCarrito(carrito); //Disparo la operacion del CRUD que modifica mi BD
			
		}
		
		
		//Solicitar HTTP PUT para modificar un platillo
		@PutMapping (path = "{Id}")
		public void updateCarrito(@PathVariable("Id")Long id_Carrito, 
			@RequestParam (required = false) Integer cantidad) {
			carritoService.actualizarCarrito(id_Carrito, cantidad);
		}
		
		
		//Solicitud HTTP DELETE para borrar un platillo
			@DeleteMapping(path = "{Id}") //borrar elementos por un id
			public void deleteCarrito(@PathVariable("Id")Long id_Carrito) {
			carritoService.borrarCarrito(id_Carrito);
			}


		
		
		//GET Platillo (GET)
		
		//POST Platillo (POST)
		
		//PUT Platillo (PUT)
		
		//DELETE Platillo (DELETE)
		
		
	}
