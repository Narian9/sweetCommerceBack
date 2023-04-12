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

import com.admonSC.model.Usuario;
import com.admonSC.service.UsuarioService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
RequestMethod.PUT })
@RestController
@RequestMapping(path = "/sweetCommerce/usuarios/")
public class UsuarioController {


private final UsuarioService usuarioService;

@Autowired
public UsuarioController(UsuarioService usuarioService) {
	this.usuarioService = usuarioService;
}

@GetMapping
public List<Usuario> getUsuarios(){
	return usuarioService.leerUsuarios();
}

@GetMapping(path = "{Id}")
public Usuario getUsuario(@PathVariable("Id")Long Id) {
	return usuarioService.leerUsuario(Id);
}

@PostMapping
public void postUsuario (@RequestBody Usuario usuario) {
	usuarioService.crearUsuario(usuario);
}

@PutMapping (path = "{Id}")
public void updateUsuario(@PathVariable("Id")Long Id, 
	@RequestParam (required = false) String nombre_Usuario,
	@RequestParam (required = false) String apellido_Usuario,
	@RequestParam (required = false) String correo_Usuario,
	@RequestParam (required = false) String password_Usuario,
	@RequestParam (required = false) String direccion_Usuario,
	@RequestParam (required = false) Boolean es_Admin) {
	usuarioService.actualizarUsuario(Id, nombre_Usuario, apellido_Usuario, correo_Usuario, password_Usuario, direccion_Usuario, es_Admin);
}

@DeleteMapping(path = "{Id}")
public void deleteUsuario(@PathVariable("Id")Long Id) {
	usuarioService.borrarUsuario(Id);
}
}