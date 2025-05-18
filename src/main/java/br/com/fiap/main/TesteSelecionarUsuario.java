package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import java.sql.SQLException;
import java.util.List;

public class TesteSelecionarUsuario {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UsuarioDAO objUsuarioDAO = new UsuarioDAO();

        List<Usuario> lista = objUsuarioDAO.selecionar();

        if (lista != null) {
            for (Usuario u : lista) {
                System.out.println(
                        u.getCpf() + " " +
                                u.getNome() + " " +
                                u.getEmail() + " " +
                                u.getDataNascimento()
                );
            }
        }
    }
}

