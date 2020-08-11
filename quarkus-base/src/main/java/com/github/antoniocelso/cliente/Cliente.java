package com.github.antoniocelso.cliente;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@Entity
public class Cliente extends PanacheEntity {

    private String nome;
    private Long idade;
    private Long cpf;
//    private Date dataNascimento;

    @CreationTimestamp
    private Date dataCriacao;

    @UpdateTimestamp
    private Date dataAtualizacao;

    public String getNome() {
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


    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) &&
                Objects.equals(idade, cliente.idade) &&
                Objects.equals(cpf, cliente.cpf) &&
                Objects.equals(dataCriacao, cliente.dataCriacao) &&
                Objects.equals(dataAtualizacao, cliente.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, cpf, dataCriacao, dataAtualizacao);
    }

}


