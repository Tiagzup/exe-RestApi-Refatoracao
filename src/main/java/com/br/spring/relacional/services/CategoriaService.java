package com.br.spring.relacional.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.spring.relacional.exceptions.CategoriaNaoEncontradaException;
import com.br.spring.relacional.models.Categoria;
import com.br.spring.relacional.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Iterable<Categoria> buscarTodasCategorias() {
		return categoriaRepository.findAll();

	}

	public long quantidadeCategoria() {
		return categoriaRepository.count();
	}

	public void cadastrarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);

	}

	public Categoria buscarCategoriaId(int id) {
		return categoriaRepository.findById(id).get();
	}

	public void atualizarCategoria(  int id, Categoria categoria) {
		Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
		if (!optionalCategoria.isPresent()) {
			throw new CategoriaNaoEncontradaException("Não há categoria nesse id");
		}

	}

	public void apagarCategoria(int id) {
		categoriaRepository.deleteById(id);
		{
			throw new CategoriaNaoEncontradaException("Não há categoria nesse id");
		}
	}
	

}
