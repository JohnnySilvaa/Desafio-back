package com.stefanini.desafio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.desafio.model.Sessao;
import com.stefanini.desafio.repository.SessaoRepository;

@CrossOrigin(origins = "*",allowedHeaders="*")
@RestController
@RequestMapping("/api/sessoes")
public class SessaoController {
	
	@Autowired
	private SessaoRepository repository;
	
	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
	
	@PostMapping()
	public Sessao createSessao(@RequestBody Sessao sessao) {
		
	      List<Sessao> sessoesDaSala =  repository.findBySala(sessao.getSala());
	    //  GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoesDaSala);

	      //if (gerenciador.cabe(sessao)) {
	    	  repository.save(sessao);
	      //}
		return sessao;
	}

	

	
	
	

			
	 
	 
	
}
