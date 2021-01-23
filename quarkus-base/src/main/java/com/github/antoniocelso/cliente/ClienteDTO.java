package com.github.antoniocelso.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ClienteDTO implements Serializable {

    private String nome;

    private Long idade;

    private Long cpf;

}


