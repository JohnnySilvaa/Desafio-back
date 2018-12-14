package com.stefanini.desafio.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.desafio.model.Lugar;
import com.stefanini.desafio.model.Sala;
import com.stefanini.desafio.repository.LugarRepository;
import com.stefanini.desafio.repository.SalaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/lugares")
public class LugarController {

	@Autowired
	private LugarRepository repository;
	@Autowired
	private SalaRepository salaRepository;

	@GetMapping
	public List<Lugar> lista() {
		return repository.findAll();
	}

	@PutMapping("/{salaId}")
	public ResponseEntity<Sala> createLugar(@PathVariable("salaId") Long salaId,@RequestBody Lugar lugar) {

		Sala sala = salaRepository.findById(salaId).get();
		sala.add(lugar);
		
		if (sala.getId() != null) {
			return new ResponseEntity<>(salaRepository.save(sala), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public Lugar getLugar(@PathVariable("salaId") Long id) {
		return repository.findById(id).get();
	}
}
