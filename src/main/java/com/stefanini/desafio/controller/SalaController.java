package com.stefanini.desafio.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.desafio.model.Lugar;
import com.stefanini.desafio.model.Sala;
import com.stefanini.desafio.model.Sessao;
import com.stefanini.desafio.repository.SalaRepository;
import com.stefanini.desafio.repository.SessaoRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/salas")
public class SalaController {

	@Autowired
	private SalaRepository repository;
	@Autowired
	private SessaoRepository sessaoRepository;

	@GetMapping("/{id}/sessoes")
	public List<Sessao> listaSessoes(@PathVariable("id") Long id) {
		Optional<Sala> sala = repository.findById(id);
		
		return sessaoRepository.findBySala(sala.get());
	}

	@GetMapping
	public List<Sala> lista() {
		return repository.findAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}

	@PostMapping
	public void createSala(@RequestBody Sala sala) {
		repository.save(sala);
	}

	@GetMapping("/{id}")
	public Sala getSala(@PathVariable("id") Long id) {
		return repository.findById(id).get();
	}


	@PutMapping("/{id}")
	public ResponseEntity<Sala> updateSala(@PathVariable("id") Long id, @RequestBody Sala sala) {
		Sala s =  getSala(id);

		if (s != null) {
			return new ResponseEntity<>(repository.save(sala), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
    @GetMapping("/{id}/lugares")
    public Map<String, List<Lugar>> listaLugares(@PathVariable("id") Long id) {

        Sala sala = repository.findById(id).get();
        return sala.getMapaDeLugares();
    }
	

}
