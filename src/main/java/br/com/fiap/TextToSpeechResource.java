package br.com.fiap;

import br.com.fiap.bo.TextToSpeechBO;
import br.com.fiap.beans.TextToSpeech;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/tts")
public class TextToSpeechResource {

    private TextToSpeechBO ttsBO = new TextToSpeechBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<TextToSpeech> selecionarRs() throws SQLException, ClassNotFoundException {
        return ttsBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(TextToSpeech objTts, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        ttsBO.inserirBO(objTts);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(objTts.getIdomaTraduzido());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{idiomaTraduzido}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(TextToSpeech objTts) throws SQLException, ClassNotFoundException {
        ttsBO.atualizarBO(objTts);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{idiomaTraduzido}")
    public Response deletarRs(@PathParam("idiomaTraduzido") String idiomaTraduzido) throws SQLException, ClassNotFoundException {
        ttsBO.deletarBO(idiomaTraduzido);
        return Response.ok().build();
    }
}
