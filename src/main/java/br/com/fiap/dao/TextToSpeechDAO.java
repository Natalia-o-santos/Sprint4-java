package br.com.fiap.dao;

import br.com.fiap.beans.TextToSpeech;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TextToSpeechDAO {

    public Connection minhaConexao;

    public TextToSpeechDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(TextToSpeech tts) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO TEXT_TO_SPEECH  VALUES (?, ?)"
        );
        stmt.setString(1, tts.getIdomaTraduzido());
        stmt.setString(2, tts.getIdomaFalado());
        stmt.execute();
        stmt.close();
        return "TextToSpeech inserido com sucesso!";
    }

    public String atualizar(TextToSpeech tts) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE TEXT_TO_SPEECH SET IDIOMA_TRADUZIDO = ?, IDIOMA_FALADO = ? "
        );
        stmt.setString(1, tts.getIdomaTraduzido());
        stmt.setString(2, tts.getIdomaFalado());
        stmt.executeUpdate();
        stmt.close();
        return "TextToSpeech atualizado com sucesso!";
    }

    public String deletar(String idiomaTraduzido) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM TEXT_TO_SPEECH WHERE IDIOMA_TRADUZIDO = ?"
        );
        stmt.setString(1, idiomaTraduzido);
        stmt.execute();
        stmt.close();
        return "TextToSpeech deletado com sucesso!";
    }

    public List<TextToSpeech> selecionar() throws SQLException {
        List<TextToSpeech> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM TEXT_TO_SPEECH");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            TextToSpeech tts = new TextToSpeech();
            tts.setIdomaTraduzido(rs.getString("IDIOMA_TRADUZIDO"));
            tts.setIdomaFalado(rs.getString("IDIOMA_FALADO"));
            lista.add(tts);
        }
        return lista;
    }
}
