package com.stefanini.desafio.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.desafio.model.Lugar;

public interface LugarRepository extends JpaRepository<Lugar, Long>  {

}
