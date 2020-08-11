package com.github.antoniocelso.cliente;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.RequestScoped;
import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.listAll;

//@Traced
@RequestScoped
public class ClienteDao implements PanacheRepository<Cliente> {
    public List<Cliente> listarClientes() {
        return listAll();
    }

    public void incluirCliente(Cliente entity) {
        persist(entity);
    }

}


