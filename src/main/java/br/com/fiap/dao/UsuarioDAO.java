package br.com.fiap.dao;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public Connection minhaConexao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO USUARIO VALUES (?, ?, ?, ?)"
        );
        stmt.setString(1, usuario.getCpf());
        stmt.setString(2, usuario.getNome());
        stmt.setString(3, usuario.getEmail());
        stmt.setString(4, usuario.getDataNascimento());

        stmt.execute();
        stmt.close();

        return "Usuário cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String cpf) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM USUARIO WHERE CPF = ?"
        );
        stmt.setString(1, cpf);

        stmt.execute();
        stmt.close();

        return "Usuário deletado com sucesso!";
    }

    // Update
    public String atualizar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE USUARIO SET NOME = ?, EMAIL = ?, DATA_NASCIMENTO = ? WHERE CPF = ?"
        );
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getDataNascimento());
        stmt.setString(4, usuario.getCpf());
        stmt.executeUpdate();
        stmt.close();

        return "Usuário atualizado com sucesso!";
    }

    // Select
    public List<Usuario> selecionar() throws SQLException {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM USUARIO"
        );
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setCpf(rs.getString("CPF"));
            usuario.setNome(rs.getString("NOME"));
            usuario.setEmail(rs.getString("EMAIL"));
            usuario.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
            // Endereço omitido por depender da modelagem

            listaUsuarios.add(usuario);
        }

        return listaUsuarios;
    }
}
