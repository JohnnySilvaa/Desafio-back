package com.stefanini.desafio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.stefanini.desafio.model.Filme;
import com.stefanini.desafio.model.Sessao;
import com.stefanini.desafio.repository.FilmeRepository;
import com.stefanini.desafio.repository.SessaoRepository;


@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/filmes")
public class FilmeController {
	@Autowired
	private FilmeRepository repository;

	@Autowired
	private SessaoRepository sessaoRepository;
	
	//ListarFilmes
	@GetMapping
	public List<Filme> lista() {
		return repository.findAll();
	}

	//DeletarFilme
	@DeleteMapping("/{id}")
	@ResponseBody
	public void delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}

	//AtualizarFilme
	@PostMapping
	public void createFilme(@RequestBody Filme filme) {
		repository.save(filme);
	}

	//RecuperarFilme
	@GetMapping("/{id}")
	public Filme getFilme(@PathVariable("id") Long id) {
		return repository.findById(id).get();
	}

	//AtualizarFilme
	@PutMapping("/{id}")
	public ResponseEntity<Filme> updateFilme(@PathVariable("id") Long id, @RequestBody Filme filme) {
		Filme f =  getFilme(id);

		if (f != null) {
			return new ResponseEntity<>(repository.save(filme), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	 @GetMapping("/em-cartaz")
	 public List<Filme> emCartaz(){
	     return repository.findAll();
	 }
	 
	 
	 @GetMapping("/filme/{id}/detalhe")
	 public List<Sessao> detalhes(@PathVariable("id") Long id){

	     Filme filme = repository.findById(id).get();
	     
	     List<Sessao> sessoes = sessaoRepository.findByFilme(filme);

	     return sessoes;
	 }

	
}
