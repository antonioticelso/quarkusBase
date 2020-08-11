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

    @PUT
//    @Path("/")
//    @RequestScoped
    @Operation(
        summary = "Alterar Carteira de Clientes",
        description = "Alterar Carteira de Clientes")
    @APIResponse(
	responseCode = "200",
	description = "Alterar Carteira de Clientes",
	content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = ClienteDTO.class))})
    @APIResponse(
	responseCode = "422",
	description = "Erro Negocial - Alterar Carteira de Clientes",
	content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Error.class))})
    @APIResponse(
	responseCode = "500",
	description = "Erro Sistema - Alterar Carteira de Clientes",
	content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Error.class))})
    public Response alterarClientes(@Valid ClienteDTO clienteDTO) throws Exception {
        return Response.status(Response.Status.OK).entity(
                clienteService.alterarClientes(clienteDTO)
        ).build();
    }

    @DELETE
    @Path("/{id}")
//    @RequestScoped
    @Operation(
        summary = "Excluir Carteira de Clientes",
        description = "Deletar Carteira de Clientes")
    @APIResponse(
	responseCode = "200",
	description = "Excluir Carteira de Clientes",
	content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = ClienteDTO.class))})
    @APIResponse(
	responseCode = "422",
	description = "Erro Negocial - Excluir Carteira de Clientes",
	content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Error.class))})
    @APIResponse(
	responseCode = "500",
	description = "Erro Sistema - Excluir Carteira de Clientes",
	content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Error.class))})
    public Response alterarClientes(@PathParam("id") Long id) throws Exception {
        return Response.status(Response.Status.OK).entity(
                clienteService.excluirClientes(id)
        ).build();
    }


}


