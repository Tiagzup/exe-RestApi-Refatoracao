package com.br.spring.relacional.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.spring.relacional.models.Login;
import com.br.spring.relacional.models.Usuario;
import com.br.spring.relacional.services.LoginService;
import com.br.spring.relacional.services.UsuarioService;

@RestController
@RequestMapping("/login")
public class LoginApiController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private UsuarioService usuarioService;
	
	public ResponseEntity<?> buscarApelidoEsenha (@RequestBody Login login ) {
		loginService.buscarPorApelidoESenha(login);
		return ResponseEntity.ok().build();
	}
	public ResponseEntity<?> cadastrarCategoria (Login login, Usuario user) {
		loginService.cadastrarLogin(user, login);
		return ResponseEntity.status(HttpStatus.CREATED).body(login);
	}
	public ResponseEntity<?> atualizarLogin (Login login){
		loginService.upadate(login);
		return ResponseEntity.ok(login);
	}
}
