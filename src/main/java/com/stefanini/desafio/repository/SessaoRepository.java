package com.stefanini.desafio.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.desafio.model.Filme;
import com.stefanini.desafio.model.Sala;
import com.stefanini.desafio.model.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long>{
	
		public List<Sessao> findBySala(Sala sala);
		public List<Sessao> findByFilme(Filme filme);

}
