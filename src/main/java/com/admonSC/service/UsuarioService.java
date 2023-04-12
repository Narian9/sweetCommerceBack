package com.admonSC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admonSC.model.Usuario;
import com.admonSC.repository.UsuarioRepository;

@Service
public class UsuarioService {

    // Atributos
    private final UsuarioRepository usuarioRepository;

  //Creo un cable para conectar entidades (PlatilloRepository - PlatilloService)
  	@Autowired
    
    // Constructor con la dependencia inyectada como parámetro
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Logica de nuestro negocio - Operaciones del CRUD

    // Crear usuario (Create)
    public void crearUsuario(Usuario usuario) {
        // Necesitamos saber si el usuario buscado existe, SI EXISTE lo ponemos dentro del optional
        Optional<Usuario> usuarioBuscado = usuarioRepository.findByName(usuario.getNombre_Usuario());
        
        if (usuarioBuscado.isPresent()) { // si el optional tiene un objeto almacenado (vacío = false)
            throw new IllegalStateException("El usuario con el nombre " + usuario.getNombre_Usuario() + " ya existe.");
        } else { // si el optional está vacío (vacío = true)
            usuarioRepository.save(usuario); // guardamos esa información en nuestra base de datos usando nuestro repository como la interface que es
        }
    }

    // Leer usuarios (Read)
    public List<Usuario> leerUsuarios() {
        return usuarioRepository.findAll();
    }

    // Leer usuario (Read)
    public Usuario leerUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new IllegalStateException("El usuario con el id " + id + " no existe."));
    }

    // Actualizar usuario (Update)
    public void actualizarUsuario(Long id, String nombre_Usuario, String apellido_Usuario, String correo_Usuario, String password_Usuario, String direccion_Usuario, Boolean es_Admin) {
        // Si el usuario existe, entonces se modifica
        if (usuarioRepository.existsById(id)) {
            // Entonces lo modificamos

            // Traemos el objeto y lo ponemos en la variable temporal
            Usuario usuarioABuscar = usuarioRepository.getById(id);
            if (nombre_Usuario != null) usuarioABuscar.setNombre_Usuario(nombre_Usuario);
            if (apellido_Usuario != null) usuarioABuscar.setApellido_Usuario(apellido_Usuario);
            if (correo_Usuario != null) usuarioABuscar.setCorreo_Usuario(correo_Usuario);
            if (password_Usuario != null) usuarioABuscar.setPassword_Usuario(password_Usuario);
            if (direccion_Usuario != null) usuarioABuscar.setDireccion_Usuario(direccion_Usuario);
            if (es_Admin != null) usuarioABuscar.setEs_Admin(es_Admin);

            // Cuando terminamos de editar el objeto...
            usuarioRepository.save(usuarioABuscar);

        } else { // si el usuario NO existe, no se puede modificar nada y se muestra mensaje
            System.out.println("El usuario con el id " + id + " no existe");
        }
    }

    // Borrar usuario (Delete)
    public void borrarUsuario(Long id) {
        // Buscamos un usuario por id y si existe...
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        }
    }
}
