package com.stefanini.desafio.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stefanini.desafio.model.Filme;
import com.stefanini.desafio.model.Sessao;

@RepositoryRestResource
public interface FilmeRepository extends JpaRepository<Filme, Long> {


}
