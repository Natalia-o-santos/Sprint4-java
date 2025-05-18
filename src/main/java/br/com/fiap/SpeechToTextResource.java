package br.com.fiap;

import br.com.fiap.beans.SpeechToText;
import br.com.fiap.bo.SpeechToTextBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/speechToText")
public class SpeechToTextResource {
private SpeechToTextBO speechToTextBO =new SpeechToTextBO();

@GET
    @Produces(MediaType.APPLICATION_JSON)
public ArrayList<SpeechToText> selecionarRs() throws SQLException, ClassNotFoundException{
    return speechToTextBO.selecionarBO();
}
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
public Response inserirRs(SpeechToText speechToText, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException{
    speechToTextBO.inserirBO(speechToText);
       UriBuilder builder =uriInfo.getAbsolutePathBuilder();
       builder.path(speechToText.getIdiomaFalado());
       return Response.created(builder.build()).build();
}
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(SpeechToText speechToText) throws SQLException,ClassNotFoundException{
    speechToTextBO.atualizarBO(speechToText);
    return Response.ok().build();
    }

    @DELETE
    @Path("/idiomaFalado")
    public Response deletarRs(@PathParam("idiomaFalado") String idiomaFalado) throws SQLException, ClassNotFoundException{
    speechToTextBO.deletarBO(idiomaFalado);
    return Response.ok().build();
    }

}
