package br.com.fiap.dao;

import br.com.fiap.beans.AudioGuia;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AudioGuiaDAO {

    public Connection minhaConexao;

    public AudioGuiaDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(AudioGuia audio) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO AUDIO_GUIA (VOLUME, IDIOMA) VALUES (?, ?)"
        );
        stmt.setInt(1, audio.getVolume());
        stmt.setString(2, audio.getIdioma());
        stmt.execute();
        stmt.close();
        return "Áudio Guia inserido com sucesso!";
    }

    public String atualizar(AudioGuia audio, String idioma) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE AUDIO_GUIA SET VOLUME = ?, IDIOMA = ? WHERE IDIOMA = ?"
        );
        stmt.setInt(1, audio.getVolume());
        stmt.setString(2, audio.getIdioma());

        stmt.executeUpdate();
        stmt.close();
        return "Áudio Guia atualizado com sucesso!";
    }

    public String deletar(String idioma) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "DELETE FROM AUDIO_GUIA WHERE IDIOMA = ?"
        );
        stmt.setString(1, idioma);
        stmt.execute();
        stmt.close();
        return "Áudio Guia deletado com sucesso!";
    }

    public List<AudioGuia> selecionar() throws SQLException {
        List<AudioGuia> lista = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM AUDIO_GUIA");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            AudioGuia a = new AudioGuia();
            a.setVolume(rs.getInt("VOLUME"));
            a.setIdioma(rs.getString("IDIOMA"));
            lista.add(a);
        }
        return lista;
    }
}
