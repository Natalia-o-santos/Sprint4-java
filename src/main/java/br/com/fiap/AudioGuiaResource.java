package br.com.fiap;


import br.com.fiap.beans.AudioGuia;
import br.com.fiap.bo.AudioGuiaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/audioguia")
public class AudioGuiaResource {
    private AudioGuiaBO audioGuiaBO = new AudioGuiaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<AudioGuia> selecionarRs() throws SQLException, ClassNotFoundException {
        return audioGuiaBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(AudioGuia audioGuia, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        audioGuiaBO.inserirBO(audioGuia);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(audioGuia.getIdioma());
        return Response.created(builder.build()).build();

    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(AudioGuia audioGuia, @PathParam("idioma") String idioma) throws SQLException, ClassNotFoundException {
        audioGuiaBO.atualizarBO(audioGuia,idioma);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{idioma}")
    public Response deletarRs(@PathParam("idioma") String idioma) throws SQLException, ClassNotFoundException {
        audioGuiaBO.deletarBO (idioma);
        return Response.ok().build();
    }
}
