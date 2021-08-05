package tlacuariders.mx.controllers;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tlacuariders.mx.models.UsuariosModel;
import tlacuariders.mx.repositories.UsuarioRepository;

import org.springframework.security.core.context.SecurityContextHolder;


@RestController
public class UsuarioController {

	private UsuarioRepository usuarioRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/usuarios/")
	public void saveUsuario(@RequestBody UsuariosModel user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usuarioRepository.save(user);
	}

	@GetMapping("/usuarios/")
	public List<UsuariosModel> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/usuarios/{username}")
	public UsuariosModel getUsuario(@PathVariable String username) {
		return usuarioRepository.findByUsername(username);
	}
	
	@GetMapping("/usuario/auth")
	public UsuariosModel getAuthUser(){
		return usuarioRepository.findByUsername((String) (SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
	}
}
