package com.br.spring.relacional.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.spring.relacional.models.Login;
import com.br.spring.relacional.models.Usuario;
import com.br.spring.relacional.services.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginserv;

	@GetMapping("/cadastro/login")
	public ModelAndView exibirFormulario() {
		ModelAndView mv = new ModelAndView("cadastro.html");
		return mv;
	}

	@PostMapping("/cadastro/login")
	public ModelAndView cadastrarLogin(@Valid Usuario user, BindingResult bindingUser, @Valid Login login,
			BindingResult bindingLogin) {
		ModelAndView mv = new ModelAndView("cadastro.html");
		if (bindingUser.hasErrors() || bindingLogin.hasErrors()) {
			List<String> msgs = new ArrayList<String>();
			for (ObjectError objerro : bindingUser.getAllErrors()) {
				msgs.add(objerro.getDefaultMessage());
			}
			for (ObjectError objerro : bindingLogin.getAllErrors()) {
				msgs.add(objerro.getDefaultMessage());
			}
			mv.addObject("msgs", msgs);
		}else {
			mv.addObject("msgs", loginserv.cadastrarLogin(user, login));
			
		}

		return mv;
	}
}
