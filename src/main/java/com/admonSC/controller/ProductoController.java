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

import com.admonSC.model.Producto;
import com.admonSC.service.ProductoService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })

@RestController //anotacion para indicar que esta clase es un controlador

@RequestMapping(path = "/sweetCommerce/productos/") //indica la ruta de nuestro endpoint par saber a donde se van a manejar esas solicitudes HTTP


public class ProductoController {

	//Inyeccion de dependencias
	private final ProductoService productoService;

	@Autowired //anotacion para relacionar e inyectar dependencia 
	
	//Constructor que usa el objeto PlatilloService como parametro
	public ProductoController (ProductoService productoService) {
		this.productoService = productoService;
	}//contructor
	

	
	//Solicitudes HTTP para traer todos los productos
	@GetMapping
	public List<Producto> getProductos(){
		return productoService.leerProductos();
	}
	
	//Solicitar HTTP para traer un producto por Id
	@GetMapping(path = "{Id}")
	//Con @PathVariable le digo a mi metodo, que la ruta que va a variar es el id, con el tipo de dato Long id

	public Producto getProducto(@PathVariable("Id")Long Id) {
		return productoService.leerProducto(Id);
	}
	
	
	//Solicitar HTTP para crear un producto
		@PostMapping
		public void postProducto (@RequestBody Producto producto) { // Que los datos que pasemos como cuerpo de nuestra solicitud, seran utilizados como campos de nuestro constructor
			productoService.crearProducto(producto); //Disparo la operacion del CRUD que modifica mi BD
			
		}
		
		
		//Solicitar HTTP PUT para modificar un platillo
		@PutMapping (path = "{Id}")
		public void updateProducto(@PathVariable("Id")Long Id, 
			@RequestParam (required = false) String nombre_Producto,
			@RequestParam (required = false) Double precio,
			@RequestParam (required = false) Integer categoria,
			@RequestParam (required = false) Boolean popular,
			@RequestParam (required = false) Boolean nuevo,
			@RequestParam (required = false) Integer existencias,
			@RequestParam (required = false) String imagen_Src) {
			productoService.actualizarProducto(Id, nombre_Producto, precio, categoria, popular, nuevo, existencias, imagen_Src);
		}
		
		
		//Solicitud HTTP DELETE para borrar un platillo
			@DeleteMapping(path = "{Id}") //borrar elementos por un id
			public void deleteProducto(@PathVariable("Id")Long Id) {
			productoService.borrarProducto(Id);
			}


		
		
		//GET Platillo (GET)
		
		//POST Platillo (POST)
		
		//PUT Platillo (PUT)
		
		//DELETE Platillo (DELETE)
		
		
	}