package br.com.fiap;

import br.com.fiap.beans.Endereco;
import br.com.fiap.bo.EnderecoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;
import oracle.jdbc.proxy.annotation.Post;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/endereco")
public class EnderecoResource {
    private EnderecoBO enderecoBO = new EnderecoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Endereco> selecionarRs() throws SQLException, ClassNotFoundException{
        return enderecoBO.selecionarBO();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Endereco endereco, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException{
        enderecoBO.inserirBO(endereco);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(endereco.getCep());
        return Response.created(builder.build()).build();

    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Endereco endereco) throws SQLException,ClassNotFoundException{
        enderecoBO.atualizarBO(endereco);
        return Response.ok().build();

    }
    @DELETE
    @Path("/{cep}")
    public Response deletarRs(@PathParam("cep") String cep) throws SQLException,
            ClassNotFoundException{
        enderecoBO.deletarBO(cep);
        return Response.ok().build();
    }
}