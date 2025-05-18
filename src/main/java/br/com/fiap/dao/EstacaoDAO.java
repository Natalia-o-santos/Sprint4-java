package br.com.fiap.dao;

import br.com.fiap.beans.Estacao;
import br.com.fiap.beans.Endereco;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstacaoDAO {

    public Connection minhaConexao;

    public EstacaoDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Estacao estacao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO ESTACAO (ID_ESTACAO, NOME_ESTACAO, CONEXOES, CEP) VALUES (?, ?, ?, ?)"
        );
        stmt.setInt(1, estacao.getIdEstacaoo());
        stmt.setString(2, estacao.getNomeEstacao());
        stmt.setString(3, estacao.getConexoes());
        stmt.setString(4, estacao.getEndereco().getCep());
        stmt.execute();
        stmt.close();
        return "Estação inserida com sucesso!";
    }

    public String atualizar(Estacao estacao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE ESTACAO SET NOME_ESTACAO = ?, CONEXOES = ?, CEP = ? WHERE ID_ESTACAO = ?"
        );
        stmt.setString(1, estacao.getNomeEstacao());
        stmt.setString(2, estacao.getConexoes());
        stmt.setString(3, estacao.getEndereco().getCep());
        stmt.setInt(4, estacao.getIdEstacaoo());
        stmt.executeUpdate();
        stmt.close();
        return "Estação atualizada com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM ESTACAO WHERE ID_ESTACAO = ?"
        );
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Estação deletada com sucesso!";
    }

    public List<Estacao> selecionar() throws SQLException {
        List<Estacao> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM ESTACAO");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Estacao e = new Estacao();
            e.setIdEstacaoo(rs.getInt("ID_ESTACAO"));
            e.setNomeEstacao(rs.getString("NOME_ESTACAO"));
            e.setConexoes(rs.getString("CONEXOES"));

            Endereco endereco = new Endereco();
            endereco.setCep(rs.getString("CEP"));
            e.setEndereco(endereco);

            lista.add(e);
        }
        return lista;
    }
}
