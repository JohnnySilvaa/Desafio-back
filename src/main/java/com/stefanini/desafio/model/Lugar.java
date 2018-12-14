package com.stefanini.desafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Lugar {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String fileira;
    @NotNull
    private String posicao;

 

}
