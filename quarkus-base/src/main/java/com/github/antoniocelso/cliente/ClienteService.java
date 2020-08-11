package com.github.antoniocelso.cliente;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
//import org.eclipse.microprofile.opentracing.Traced

//@Traced
@RequestScoped
public class ClienteService {

    @Inject
    ClienteDao clienteDao;

    @Inject
    ClienteDTO clienteDTO;

    @Transactional
    public List<Cliente> listarClientes() {

        return clienteDao.listarClientes();
    }

    @Transactional
    public ClienteDTO incluirCliente(ClienteDTO clienteDTO) {

        Cliente entity = new Cliente();
        clienteDao.incluirCliente(entity);

        return clienteDTO;
    }

    @Transactional
    public Cliente alterarClientes(ClienteDTO clienteDTO) {
        Cliente entity = clienteDao.findById(clienteDTO.getNome());

        return entity;
    }

    @Transactional
    public Long excluirClientes(Long id) {
        clienteDao.delete(clienteDao.findById(id));

        return id;
    }
}


