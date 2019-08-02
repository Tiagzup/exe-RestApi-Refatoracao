package com.br.spring.relacional.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.spring.relacional.models.Produto;
import com.br.spring.relacional.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoApiController {
	@Autowired
	private ProdutoService produtoService;
	
	public ResponseEntity<?> buscarProduto (){
		if(produtoService.quantidadeProduto() > 0) {
			return ResponseEntity.ok(produtoService.buscarTodosPrdutos());
			
		}
		return ResponseEntity.ok().build();		
	}
	@GetMapping("{id}")
	public ResponseEntity<?> buscarProdutoPorId (@PathVariable int id){
		produtoService.buscarProdutoPorId(id);
		return ResponseEntity.ok().build();
	}
	@PostMapping
	public ResponseEntity<?> cadastrarProduto (@Valid @RequestBody Produto produto ) {
		produtoService.cadastrarProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> apagarProduto (@PathVariable int id) {
		produtoService.apagarProduto(id);
		return ResponseEntity.ok().build();
	}
	@PutMapping
	public ResponseEntity<?> atualizarProduto (@PathVariable int id,
			@Valid @RequestBody Produto produto) {
		produtoService.atualizarProduto(id, produto);
		return ResponseEntity.status(HttpStatus.OK).body(produto);
	}
	
}

















