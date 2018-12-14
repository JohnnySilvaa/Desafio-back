package com.stefanini.desafio.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.desafio.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

}
