package br.com.fiap.dao;

import br.com.fiap.beans.Linha;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LinhaDAO {

    public Connection minhaConexao;

    public LinhaDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Linha linha) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO LINHA VALUES (?, ?, ?)"
        );
        stmt.setInt(1, linha.getIdLinha());
        stmt.setString(2, linha.getNome());
        stmt.setString(3, linha.getCor());
        stmt.execute();
        stmt.close();
        return "Linha inserida com sucesso!";
    }

    public String atualizar(Linha linha) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE LINHA SET NOME_LINHA = ?, COR = ? WHERE ID_LINHA = ?"
        );
        stmt.setString(1, linha.getNome());
        stmt.setString(2, linha.getCor());
        stmt.setInt(3, linha.getIdLinha());
        stmt.executeUpdate();
        stmt.close();
        return "Linha atualizada com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM LINHA WHERE ID_LINHA = ?"
        );
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Linha deletada com sucesso!";
    }

    public List<Linha> selecionar() throws SQLException {
        List<Linha> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM LINHA");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Linha l = new Linha();
            l.setIdLinha(rs.getInt("ID_LINHA"));
            l.setNome(rs.getString("NOME_LINHA"));
            l.setCor(rs.getString("COR"));
            lista.add(l);
        }
        return lista;
    }
}
