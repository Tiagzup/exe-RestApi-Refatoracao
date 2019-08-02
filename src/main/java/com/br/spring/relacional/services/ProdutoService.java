package com.br.spring.relacional.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.spring.relacional.exceptions.ProdutoNaoEncontradoException;
import com.br.spring.relacional.models.Produto;
import com.br.spring.relacional.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Iterable<Produto> buscarTodosPrdutos(){
		return produtoRepository.findAll();
		
	
	}
	public Produto buscarProdutoPorId(int id) {
		return produtoRepository.findById(id).get();
	}
	
	public void cadastrarProduto(Produto produto) {
		produtoRepository.save(produto);
			
	}
	
	public void apagarProduto(int id) {
		produtoRepository.deleteById(id);
		{
			throw new ProdutoNaoEncontradoException("Produto não encontrado nesse id");
		}
	}
	public void atualizarProduto (int id, Produto produto) {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		if (!optionalProduto.isPresent()) {
			throw new ProdutoNaoEncontradoException ("Produto não encontrado nesse id");
		}
	}
	public long quantidadeProduto () {
		return produtoRepository.count();
	}
	
	
}
