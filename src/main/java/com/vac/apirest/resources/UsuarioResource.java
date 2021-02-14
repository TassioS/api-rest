package com.vac.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vac.apirest.models.Usuario;
import com.vac.apirest.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API Rest para cadastro de usuários.")
@CrossOrigin(origins = "*")
public class UsuarioResource {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/users")
	@ApiOperation(value = "Lista todos os usuários cadastrados.")
	public List<Usuario> listUsers(){
		return usuarioRepository.findAll();
	}
	
	@PostMapping("/user")
	@ApiOperation(value = "Método para registrar uma usuário.")
	public ResponseEntity<HttpStatus> addUser(@RequestBody Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
}
