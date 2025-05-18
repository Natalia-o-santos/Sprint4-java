package br.com.fiap;

import br.com.fiap.bo.EstacaoBO;
import br.com.fiap.beans.Estacao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/estacao")
public class EstacaoResource {
    private EstacaoBO estacaoBO = new EstacaoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Estacao> selecionarRs() throws SQLException, ClassNotFoundException {
        return estacaoBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Estacao estacao, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        estacaoBO.inserirBO(estacao);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(estacao.getIdEstacaoo()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Estacao estacao, @PathParam("idEstacao") int idEstacao) throws SQLException, ClassNotFoundException {
        estacaoBO.atualizarBO(estacao);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{idEstacao}")
    public Response deletarRs(@PathParam("idEstacao") int idEstacao) throws SQLException, ClassNotFoundException {
        estacaoBO.deletarBO(idEstacao);
        return Response.ok().build();
    }
}
