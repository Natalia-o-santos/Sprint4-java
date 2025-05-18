package br.com.fiap;

import br.com.fiap.bo.LinhaBO;
import br.com.fiap.beans.Linha;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;
@Provider
@Path("/linha")
public class LinhaResource {

    private LinhaBO linhaBO = new LinhaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Linha> selecionarRs() throws SQLException, ClassNotFoundException {
        return linhaBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Linha linha, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        linhaBO.inserirBO(linha);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Linha linha) throws SQLException, ClassNotFoundException {
        linhaBO.atualizarBO(linha);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{idLinha}")
    public Response deletarRs(@PathParam("idLinha") int idLinha) throws SQLException, ClassNotFoundException {
        linhaBO.deletarBO(idLinha);
        return Response.ok().build();
    }
}
