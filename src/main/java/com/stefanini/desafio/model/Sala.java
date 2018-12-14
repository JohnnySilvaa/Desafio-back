package com.stefanini.desafio.model;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Sala {

	@Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String nome;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Lugar> lugares = new ArrayList<>();
    private BigDecimal preco;

    public void add(Lugar lugar) {
        this.lugares.add(lugar);
    }

    public Map<String, List<Lugar>> getMapaDeLugares() {
        if(!this.lugares.isEmpty()){
            return this.lugares.stream().collect(Collectors.groupingBy(Lugar::getFileira,Collectors.toList()));
        }
        return Collections.emptyMap();
    }

    public Long lugar(String fileira, Integer posicao){
        Optional<Lugar> optional = this.lugares.stream().filter((x) -> fileira.equals(x.getFileira()) && posicao.equals(x.getPosicao())).findFirst();
        return optional.get().getId();
    }


}