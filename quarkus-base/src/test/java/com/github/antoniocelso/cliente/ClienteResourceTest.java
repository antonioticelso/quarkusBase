package com.github.antoniocelso.cliente;

import io.quarkus.test.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ClienteResourceTest {

    @InjectMocks
    ClienteResource clienteResource;

    @Mock
    ClienteService clienteService;

    private final String nome = "Chico";
    private final Long idade = 32L;
    private final Long cpf = 32112355576L;

    List<ClienteDTO> listMock = new ArrayList<>();
    ClienteDTO dto = new ClienteDTO(nome, idade, cpf);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        listMock.add(dto);
    }

    public void deveAcessarEndPointListarCliente() {
        Mockito.when(clienteService.listarClientes()).thenReturn();
    }

}


