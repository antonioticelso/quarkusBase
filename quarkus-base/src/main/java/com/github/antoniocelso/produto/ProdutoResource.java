package com.github.antoniocelso;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Entity
public class ProdutoResource {

    @GET
    public List<Produto> buscarProdutos(){
        return Produto.listAll();
    }

    @POST
    public void  buscarProdutos(CadastroProdutoDTO produtoDTO){
        Produto.listAll();
    }

}


