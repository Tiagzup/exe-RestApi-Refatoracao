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

import com.br.spring.relacional.models.Produto;
import com.br.spring.relacional.services.CategoriaService;
import com.br.spring.relacional.services.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/produtos")
	public ModelAndView exibirProdutos() {
		ModelAndView modelAndView = new ModelAndView("produtos.html");
		modelAndView.addObject("produtos", produtoService.buscarTodosPrdutos());
		return modelAndView;
	}
	
	@GetMapping("/cadastrar/produtos")
	public ModelAndView exibirFormulario() {
		ModelAndView modelAndView = new ModelAndView("cadastroProduto.html");
		modelAndView.addObject("categorias", categoriaService.buscarTodasCategorias());
		return modelAndView;
	}

	@PostMapping("/cadastrar/produtos")
	public ModelAndView cadastrarProduto(@Valid Produto produto, BindingResult bindingProduto
			) {
		
		ModelAndView modelAndView = new ModelAndView("cadastroProduto.html");
		modelAndView.addObject("categorias", categoriaService.buscarTodasCategorias());
		if(bindingProduto.hasErrors()) {
			List<String> mensagens = new ArrayList<String>();
			for(ObjectError erros : bindingProduto.getAllErrors()) {
				mensagens.add(erros.getDefaultMessage());
			}
			modelAndView.addObject("mensagens", mensagens);
		}else {
			modelAndView.addObject("mensagens", produtoService.cadastrarProduto(produto));
		}
		return modelAndView;
	}
}
