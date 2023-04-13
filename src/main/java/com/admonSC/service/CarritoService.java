package com.admonSC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admonSC.model.Carrito;
import com.admonSC.repository.CarritoRepository;

//Le indicamos al Application Context que esta clase es un Servicio
@Service


public class CarritoService {

	
	//Que voy a relacionar, como lo voy a relacionar, cuando lo voy a utilizar
	
	//Primero declaro una varible del tipo PlatilloRepository para usarla cuando la necesite
	private final CarritoRepository carritoRepository;
	

	//Creo un cable para conectar entidades (PlatilloRepository - PlatilloService)
	@Autowired
	
	
	//Uso ese objeto como parametro de mi constructor
	public CarritoService (CarritoRepository carritoRepository) {
		this.carritoRepository = carritoRepository;
	}//constructor con la dependencia inyectada como parametro
	

	//Logica de nuestro negocio - Operaciones del CRUD
	
	
	//Crear platillo (Create)
			public void crearCarrito(Carrito cantidad) {
				//Necesitamos saber si el producto buscado existe, SI EXISTE lo ponemos dentro del optional
				Optional<Carrito> carritoBuscado =
						carritoRepository.findByName(cantidad.getCantidad()); //buscamos por nombre
				
				if (carritoBuscado.isPresent()) { //si el optional tiene un objeto almacenado (vacio = false)
				throw new IllegalStateException("El platillo con el nombre " + cantidad.getCantidad() + " ya existe.");
				} else { //si el optional esta vacio (vacio = true)
					carritoRepository.save(cantidad); //guardo esa informacin en mi base de datos usando mi repository como la interface que es
				}
				
			}
	
	
	//Leer platillos (Read)
	public List<Carrito> leerCarrito(){ //
		return carritoRepository.findAll();
	}
	
	//Leer platillo (Read)
		public Carrito leerCarrito(Long id_Carrito) {
			return carritoRepository.findById(id_Carrito).orElseThrow(()-> new IllegalStateException("El carrito " + "con el id " + id_Carrito + " no existe.") );
		}

	
	
	
	
	
	
		//Actualizar carrito (Update)
		
			public void actualizarCarrito(Long id_Carrito, Integer cantidad) {
				
				//Si el producto existe, entonces se modifica
				if (carritoRepository.existsById(id_Carrito)) {
					//Entonces lo modifico
					
					//traigo el objeto, y lo pongo en la variable temporal
					Carrito carritoABuscar= carritoRepository.getById(id_Carrito);
					if (cantidad!=null) carritoABuscar.setCantidad(cantidad);
					
					//Cuando termino de editar el objeto...
					carritoRepository.save(carritoABuscar);
					
					//Si el producto NO existe, no se puede modificar nada y se muestra mensaje
					
				} else {
					System.out.println("El producto en el id" + id_Carrito + " no existe");
				}
			}
			
			
			//Borrar platillo (Delete)
			
			public void borrarCarrito(Long id_Carrito) {
				
				//Buscamos un platillo por Id, y si existe...
				if(carritoRepository.existsById(id_Carrito)) {
					carritoRepository.deleteById(id_Carrito);
				}
			}


		
		
	}
