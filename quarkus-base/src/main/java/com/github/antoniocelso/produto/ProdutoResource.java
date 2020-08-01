package com.github.antoniocelso.produto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> listarProdutos() {
        return Produto.listAll();
    }

//    @POST
//    public void listarProdutos(Cadas) {
//        Produto.listAll();
//    }
}
