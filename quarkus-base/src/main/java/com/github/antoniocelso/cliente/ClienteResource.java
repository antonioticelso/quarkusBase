package com.github.antoniocelso.cliente;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("/v1/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    @GET
//    @Path("/")
//    @RequestScoped
    @Operation(
        summary = "Listar Carteira de Clientes",
        description = "Listar Carteira de Clientes")
    @APIResponse(
	responseCode = "200",
	description = "Listar Carteira de Clientes",
	content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = ClienteDTO.class))})
    @APIResponse(
	responseCode = "422",
	description = "Erro Negocial - Listar Carteira de Clientes",
	content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Error.class))})
    @APIResponse(
	responseCode = "500",
	description = "Erro Sistema - Listar Carteira de Clientes",
	content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Error.class))})
    public Response listarClientes() throws Exception {
        return Response.status(Response.Status.OK).entity(
                clienteService.listarClientes()
        ).build();
    }

    @POST
//    @Path("/")
//    @RequestScoped
    @Operation(
        summary = "Incluir Carteira de Clientes",
        description = "Incluir Carteira de Clientes")
    @APIResponse(
	responseCode = "200",
	description = "Incluir Carteira de Clientes",
	content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = ClienteDTO.class))})
    @APIResponse(
	responseCode = "422",
	description = "Erro Negocial - Incluir Carteira de Clientes",
	content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Error.class))})
    @APIResponse(
	responseCode = "500",
	description = "Erro Sistema - Incluir Carteira de Clientes",
	content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Error.class))})
    public Response incluirClientes(@Valid ClienteDTO clienteDTO) throws Exception {
        return Response.status(Response.Status.OK).entity(
                clienteService.incluirCliente(clienteDTO)
        ).build();
    }

}

//    public Response incluirCartaoNonPerso(@Valid CartaoNonPersoDTO cartaoNonPersoDTO) throws Exception {
//        return Response.status(Response.Status.OK).entity(
//                cartoesNonPersoService.incluirCartaoNonPerso(cartaoNonPersoDTO)
//        ).build();
//    }
//
//    @PUT
//    @Path("/")
//    @Produces(MediaType.APPLICATION_JSON)
//    @LogBB
//    @MetricaBB
//    // Anotacao para documentacao
//    @Operation(summary = "Alterar Cartao Non Perso no Estoque",
//            description = "Alterar Cartao Non Perso no Estoque"
//    )
//    @APIResponse(
//            responseCode = "200",
//            description = "OK",
//            content = { @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = CartaoNonPersoDTO.class))})
//    @APIResponse(responseCode = "422",
//            description = "Erro Negocial",
//            content = { @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = ListaErro.class))})
//    @APIResponse(responseCode = "500",
//            description = "Erro Sistema",
//            content = { @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = ListaErro.class))})
//    public Response alterar(CartaoNonPersoDTO cartaoNonPerso) throws Exception {
//        return Response.status(Response.Status.OK).entity(
//                cartoesNonPersoService.alterar(cartaoNonPerso)).build();
//    }
//
//    @DELETE
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    //Anotacao para metricas padroes e Log
//    @LogBB
//    @MetricaBB
//    // Anotacao para documentacao
//    @Operation(summary = "Inclusão de Cartão Non Perso",
//            description = "Inclusão de Cartão Non Perso")
//    @APIResponse(
//            responseCode = "200",
//            description = "Cartão Non Perso Incluído com Sucesso" ,
//            content = { @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = CartaoNonPersoDTO.class))})
//    @APIResponse(responseCode = "422",
//            description = "Erro Negocial",
//            content = { @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = ListaErro.class))})
//    @APIResponse(responseCode = "500",
//            description = "Erro Sistema",
//            content = { @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = ListaErro.class))})
//    public Response excluir(@PathParam("id") Long id) throws Exception {
//        return Response.status(Response.Status.OK).entity(
//                cartoesNonPersoService.excluir(id)
//        ).build();
//    }
//
//    @PUT
//    @Path("/destruir-cartao")
//    @Produces(MediaType.APPLICATION_JSON)
//    @LogBB
//    @MetricaBB
//    // Anotacao para documentacao
//    @Operation(summary = "Muda o status do cartão para 'DESTRUIDO' ",
//            description = "Muda o status do cartão para 'DESTRUIDO' "
//    )
//    @APIResponse(
//            responseCode = "200",
//            description = "OK",
//            content = { @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = CartaoNonPersoDTO.class))})
//    @APIResponse(responseCode = "422",
//            description = "Erro Negocial",
//            content = { @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = ListaErro.class))})
//    @APIResponse(responseCode = "500",
//            description = "Erro Sistema",
//            content = { @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = ListaErro.class))})
//    public Response destruirCartao(@Valid DestruirCartaoNonPersoDTO solicitacao ) throws Exception {
//        return Response.status(Response.Status.OK).entity(
//                destruicaoCartaoNonPersoService.destruirCartao( solicitacao ) ).build();
//    }
//
//    @POST
//    @Path("/destruir-cartao/listar")
//    @Produces(MediaType.APPLICATION_JSON)
//    @LogBB
//    @MetricaBB
//    // Anotacao para documentacao
//    @Operation(summary = "Retorna uma lista de cartões que podem ser destruidos ",
//            description = "Retorna uma lista de cartões que podem ser destruidos "
//    )
//    @APIResponse(
//            responseCode = "200",
//            description = "OK",
//            content = { @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = FiltroCartaoDestruidoDTO.class))})
//    @APIResponse(responseCode = "422",
//            description = "Erro Negocial",
//            content = { @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = ListaErro.class))})
//    @APIResponse(responseCode = "500",
//            description = "Erro Sistema",
//            content = { @Content(mediaType = "application/json",
//                    schema = @Schema(implementation = ListaErro.class))})
//    public Response listarCartao(@Valid FiltroCartaoDestruidoDTO filtroCartaoDestruidoDTO) throws Exception {
//        return Response.status(Response.Status.OK).entity(
//                destruicaoCartaoNonPersoService.listarCartoesDestruirFiltrados( filtroCartaoDestruidoDTO ) ).build();
//    }
//
//}
