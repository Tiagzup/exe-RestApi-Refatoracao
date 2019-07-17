package com.br.spring.relacional.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.spring.relacional.models.Produto;
import com.br.spring.relacional.repositories.CategoriaRepository;
import com.br.spring.relacional.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public String cadastrarProduto(Produto produto) {
		
		produtoRepository.save(produto);
		
		return "Produto Cadastrado com Sucesso";
	}
	
	public Iterable<Produto> buscarTodosPrdutos(){
		return produtoRepository.findAll();
	}
}
