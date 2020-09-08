package com.github.antoniocelso.cliente;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class Cliente extends PanacheEntity {

    private String nome;
    private Long idade;
    private Long cpf;
    private Date dataNascimento;

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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        return nome.equals(cliente.nome) &&
                idade.equals(cliente.idade) &&
                cpf.equals(cliente.cpf) &&
                dataNascimento.equals(cliente.dataNascimento) &&
                dataCriacao.equals(cliente.dataCriacao) &&
                dataAtualizacao.equals(cliente.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, cpf, dataNascimento, dataCriacao, dataAtualizacao);
    }
}


