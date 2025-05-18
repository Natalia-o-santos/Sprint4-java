package br.com.fiap.dao;

import br.com.fiap.beans.SpeechToText;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpeechToTextDAO {

    public Connection minhaConexao;

    public SpeechToTextDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(SpeechToText speech) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO SPEECH_TO_TEXT (IDIOMA_FALADO, IDIOMA_ESCRITO) VALUES (?, ?)"
        );
        stmt.setString(1, speech.getIdiomaFalado());
        stmt.setString(2, speech.getIdiomaEscrito());
        stmt.execute();
        stmt.close();
        return "SpeechToText inserido com sucesso!";
    }

    public String atualizar(SpeechToText speech) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE SPEECH_TO_TEXT SET IDIOMA_FALADO = ?, IDIOMA_ESCRITO = ?"
        );
        stmt.setString(1, speech.getIdiomaFalado());
        stmt.setString(2, speech.getIdiomaEscrito());

        stmt.executeUpdate();
        stmt.close();
        return "SpeechToText atualizado com sucesso!";
    }

    public String deletar(String idiomaFalado) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM SPEECH_TO_TEXT WHERE IDIOMA-FALADO = ?"
        );
        stmt.setString(1, idiomaFalado);
        stmt.execute();
        stmt.close();
        return "SpeechToText deletado com sucesso!";
    }

    public List<SpeechToText> selecionar() throws SQLException {
        List<SpeechToText> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM SPEECH_TO_TEXT");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            SpeechToText s = new SpeechToText();
            s.setIdiomaFalado(rs.getString("IDIOMA_FALADO"));
            s.setIdiomaEscrito(rs.getString("IDIOMA_ESCRITO"));
            lista.add(s);
        }
        return lista;
    }
}
