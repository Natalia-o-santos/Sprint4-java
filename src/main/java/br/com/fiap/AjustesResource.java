package br.com.fiap;

import br.com.fiap.bo.AjustesBO;
import br.com.fiap.beans.Ajustes;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;
@Provider
@Path("/ajustes")
public class AjustesResource {

    private AjustesBO ajustesBO = new AjustesBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Ajustes> selecionarRs() throws SQLException, ClassNotFoundException {
        return ajustesBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Ajustes ajustes, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        ajustesBO.inserirBO(ajustes);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(ajustes.getIdioma());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{idioma}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Ajustes ajustes, @PathParam("idioma") String idioma) throws SQLException, ClassNotFoundException {
        ajustesBO.atualizarBO(ajustes, idioma);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{idioma}")
    public Response deletarRs(@PathParam("idioma") String idioma) throws SQLException, ClassNotFoundException {
        ajustesBO.deletarBO(idioma);
        return Response.ok().build();
    }
}
