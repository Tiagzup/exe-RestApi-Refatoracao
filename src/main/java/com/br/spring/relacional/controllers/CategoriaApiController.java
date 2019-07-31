package com.br.spring.relacional.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.spring.relacional.models.Categoria;
import com.br.spring.relacional.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaApiController {
	@Autowired
	private CategoriaService categoriaService;
	
	public ResponseEntity buscarCategoria(){
		if(categoriaService.quantidadeCategoria() > 0) {
			return ResponseEntity.ok(categoriaService.buscarTodasCategorias());
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> buscarCategoriaPeloId(@PathVariable int id) {
		categoriaService.buscarCategoriaId(id);
		return ResponseEntity.ok().build();
				
		}
	@PostMapping
	public ResponseEntity<?> criarCategoria(@Valid @RequestBody Categoria categoria) {
		categoriaService.cadastrarCategoria(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
	}
	
	
}
//Mensagem mensagem = mensagemService.pegarMensagemPeloId(id);
//return ResponseEntity.ok(mensagem);


//categoriaService.buscarTodasCategorias(id, categoria);
//return ResponseEntity.ok(categoria);