package com.github.antoniocelso.produto;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/v1/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> listarProdutos() {
        return Produto.listAll();
    }

    @POST
    @Transactional
    public void listarProdutos(ProdutoDTO dto) {

        Produto produto = new Produto();

        produto.nome = dto.nome;
        produto.valor = dto.valor;
        produto.persist();

    }

    @PUT
    @Path("{id}")
    @Transactional
    public void atualizarProdutos(@PathParam("id") Long id, ProdutoDTO dto) {

        Optional<Produto> produtoOptional = Produto.findByIdOptional(id);

        if ( produtoOptional.isPresent() ) {
            Produto produto = produtoOptional.get();
            produto.nome = dto.nome;
            produto.valor = dto.valor;
            produto.persist();

        } else {
            throw new NotFoundException();
        }

    }

}
