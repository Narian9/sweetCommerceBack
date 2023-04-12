package com.admonSC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admonSC.model.Producto;
import com.admonSC.repository.ProductoRepository;

//Le indicamos al Application Context que esta clase es un Servicio
@Service


public class ProductoService {

	
	//Que voy a relacionar, como lo voy a relacionar, cuando lo voy a utilizar
	
	//Primero declaro una varible del tipo PlatilloRepository para usarla cuando la necesite
	private final ProductoRepository productoRepository;
	

	//Creo un cable para conectar entidades (PlatilloRepository - PlatilloService)
	@Autowired
	
	
	//Uso ese objeto como parametro de mi constructor
	public ProductoService (ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}//constructor con la dependencia inyectada como parametro
	

	//Logica de nuestro negocio - Operaciones del CRUD
	
	
	//Crear platillo (Create)
			public void crearProducto(Producto producto) {
				//Necesitamos saber si el producto buscado existe, SI EXISTE lo ponemos dentro del optional
				Optional<Producto> productoBuscado =
						productoRepository.findByName(producto.getNombre_Producto()); //buscamos por nombre
				
				if (productoBuscado.isPresent()) { //si el optional tiene un objeto almacenado (vacio = false)
				throw new IllegalStateException("El platillo con el nombre " + producto.getNombre_Producto() + " ya existe.");
				} else { //si el optional esta vacio (vacio = true)
					productoRepository.save(producto); //guardo esa informacin en mi base de datos usando mi repository como la interface que es
				}
				
			}
	
	
	//Leer platillos (Read)
	public List<Producto> leerProductos(){ //
		return productoRepository.findAll();
	}
	
	//Leer platillo (Read)
		public Producto leerProducto(Long Id) {
			return productoRepository.findById(Id).orElseThrow(()-> new IllegalStateException("El Producto " + "con el id " + Id + " no existe.") );
		}

	
	
	
	
	
	
		//Actualizar platillo (Update)
		
			public void actualizarProducto(Long id, String nombre_Producto, Double precio, Integer categoria,
					Boolean popular, Boolean nuevo, Integer existencias, String imagen_Src) {
				
				//Si el producto existe, entonces se modifica
				if (productoRepository.existsById(id)) {
					//Entonces lo modifico
					
					//traigo el objeto, y lo pongo en la variable temporal
					Producto productoABuscar= productoRepository.getById(id);
					if (nombre_Producto!=null) productoABuscar.setNombre_Producto(nombre_Producto);
					if (precio!=null) productoABuscar.setPrecio(precio);
					if (categoria!=null) productoABuscar.setCategoria(categoria);
					if (popular!=null) productoABuscar.setPopular(popular);
					if (nuevo!=null) productoABuscar.setNuevo(nuevo);
					if (existencias!=null) productoABuscar.setExistencias(existencias);
					if (imagen_Src!=null) productoABuscar.setImagen_Src(imagen_Src);
					
					//Cuando termino de editar el objeto...
					productoRepository.save(productoABuscar);
					
					//Si el producto NO existe, no se puede modificar nada y se muestra mensaje
					
				} else {
					System.out.println("El producto en el id" + id + " no existe");
				}
			}
			
			
			//Borrar platillo (Delete)
			
			public void borrarProducto(Long Id) {
				
				//Buscamos un platillo por Id, y si existe...
				if(productoRepository.existsById(Id)) {
					productoRepository.deleteById(Id);
				}
			}


		
		
	}
