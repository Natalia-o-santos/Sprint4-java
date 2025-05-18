package br.com.fiap.dao;

import br.com.fiap.beans.Ajustes;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AjustesDAO {

    public Connection minhaConexao;

    public AjustesDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Ajustes ajustes) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO AJUSTES VALUES (?, ?, ?)"
        );
        stmt.setInt(1, ajustes.getBrilho());
        stmt.setInt(2, ajustes.getTamanhoFonte());
        stmt.setString(3, ajustes.getIdioma());
        stmt.execute();
        stmt.close();
        return "Ajustes inseridos com sucesso!";
    }

    public String atualizar(Ajustes ajustes, String id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE AJUSTES SET BRILHO = ?, TAMANHO_FONTE = ?, IDIOMA = ? WHERE ID_AJUSTES = ?"
        );
        stmt.setInt(1, ajustes.getBrilho());
        stmt.setInt(2, ajustes.getTamanhoFonte());
        stmt.setString(3, ajustes.getIdioma());

        stmt.executeUpdate();
        stmt.close();
        return "Ajustes atualizados com sucesso!";
    }

    public String deletar(String idioma) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM AJUSTES WHERE IDIOMA = ?");
        stmt.setString(1, idioma);
        stmt.execute();
        stmt.close();
        return "Ajustes deletados com sucesso!";
    }

    public List<Ajustes> selecionar() throws SQLException {
        List<Ajustes> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM AJUSTES");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Ajustes a = new Ajustes();
            a.setBrilho(rs.getInt("BRILHO"));
            a.setTamanhoFonte(rs.getInt("TAMANHO_FONTE"));
            a.setIdioma(rs.getString("IDIOMA"));
            lista.add(a);
        }
        return lista;
    }
}
