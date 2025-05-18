package br.com.fiap.dao;

import br.com.fiap.beans.Endereco;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

    public Connection minhaConexao;

    public EnderecoDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Endereco endereco) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO ENDERECO VALUES (?, ?, ?, ?, ?, ?)"
        );
        stmt.setString(1, endereco.getLogradouro());
        stmt.setInt(2, endereco.getNumero());
        stmt.setString(3, endereco.getComplemento());
        stmt.setString(4, endereco.getCep());
        stmt.setString(5, endereco.getBairro());
        stmt.setString(6, endereco.getCidade());

        stmt.execute();
        stmt.close();

        return "Endereço cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String cep) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM ENDERECO WHERE CEP = ?"
        );
        stmt.setString(1, cep);

        stmt.execute();
        stmt.close();

        return "Endereço deletado com sucesso!";
    }

    // Update
    public String atualizar(Endereco endereco) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE ENDERECO SET LOGRADOURO = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?, CIDADE = ? WHERE CEP = ?"
        );
        stmt.setString(1, endereco.getLogradouro());
        stmt.setInt(2, endereco.getNumero());
        stmt.setString(3, endereco.getComplemento());
        stmt.setString(4, endereco.getBairro());
        stmt.setString(5, endereco.getCidade());
        stmt.setString(6, endereco.getCep());

        stmt.executeUpdate();
        stmt.close();

        return "Endereço atualizado com sucesso!";
    }

    // Select
    public List<Endereco> selecionar() throws SQLException {
        List<Endereco> listaEnderecos = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM ENDERECO"
        );
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Endereco endereco = new Endereco();
            endereco.setLogradouro(rs.getString("LOGRADOURO"));
            endereco.setNumero(rs.getInt("NUMERO"));
            endereco.setComplemento(rs.getString("COMPLEMENTO"));
            endereco.setCep(rs.getString("CEP"));
            endereco.setBairro(rs.getString("BAIRRO"));
            endereco.setCidade(rs.getString("CIDADE"));
            listaEnderecos.add(endereco);
        }

        return listaEnderecos;
    }
}
