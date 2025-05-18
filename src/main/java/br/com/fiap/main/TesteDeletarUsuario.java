package br.com.fiap.main;

import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarUsuario {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UsuarioDAO dao = new UsuarioDAO();

        String cpf = texto("Informe o CPF do usuário a ser deletado");

        System.out.println(dao.deletar(cpf));
    }
}
