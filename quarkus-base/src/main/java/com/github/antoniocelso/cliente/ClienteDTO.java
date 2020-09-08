package com.github.antoniocelso.cliente;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteDTO implements Serializable {

    private String nome;

    private Long idade;

    private Long cpf;

}


