package br.edu.ceub.navcrud.persistencia;

import java.util.List;

import br.edu.ceub.navcrud.model.Contato;

public interface IContatoDAO {

    public boolean salvar(Contato contato);
    public boolean atualizar(Contato contato);
    public boolean deletar(Contato contato);
    public List<Contato> listar();

}
