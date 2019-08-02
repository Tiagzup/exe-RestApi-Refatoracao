package com.br.spring.relacional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.spring.relacional.models.Login;
import com.br.spring.relacional.models.Usuario;
import com.br.spring.relacional.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepo;
	
	public void buscarPorApelidoESenha(Login login) {
		loginRepo.findByApelidoAndSenha(login.getApelido(), login.getSenha()).get();
	}

	public void cadastrarLogin(Usuario user, Login login) {
		login.setUsuario(user);
		loginRepo.save(login);

	}

	public void upadate(Login login) {
		loginRepo.save(login);
	}

	
}
