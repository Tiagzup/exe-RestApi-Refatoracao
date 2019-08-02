package com.br.spring.relacional.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.br.spring.relacional.exceptions.CategoriaNaoEncontradaException;
import com.br.spring.relacional.helpers.DetailsError;

@RestController
@ControllerAdvice
public class CategoriaControllerAdvice {
	@ExceptionHandler(CategoriaNaoEncontradaException.class)
	public ResponseEntity<DetailsError> handleCategoriaNaoEncontradaException (CategoriaNaoEncontradaException e, 
			WebRequest requisicao) {
		DetailsError detailsError = new DetailsError(e.getMessage(), 
				requisicao.getDescription(false), HttpStatus.NOT_FOUND);
		return ResponseEntity.status(detailsError.getStatus()).body(detailsError);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DetailsError> handleMethodArgumentNotValidException(
										MethodArgumentNotValidException e,
										WebRequest requisicao) {
		DetailsError detailsError = new DetailsError(e.getMessage(),
													 requisicao.getDescription(false),
													 HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(detailsError.getStatus()).body(detailsError);
	}
			
}
