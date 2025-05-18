package br.com.fiap;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.beans.Usuario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/usuario")
public class UsuarioResource {

    private UsuarioBO usuarioBO = new UsuarioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Usuario> selecionarRs() throws SQLException, ClassNotFoundException {
        return usuarioBO.selecionarBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Usuario usuario, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        usuarioBO.inserirBO(usuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(usuario.getCpf());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Usuario usuario) throws SQLException, ClassNotFoundException {
        usuarioBO.atualizarBO(usuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{cpf}")
    public Response deletarRs(@PathParam("cpf") String cpf) throws SQLException, ClassNotFoundException {
        usuarioBO.deletarBO(cpf);
        return Response.ok().build();
    }
}
