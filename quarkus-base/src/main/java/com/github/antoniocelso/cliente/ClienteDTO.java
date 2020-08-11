package com.github.antoniocelso.cliente;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private String nome;

    private Long idade;

    private Long cpf;

    public Long getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

}


