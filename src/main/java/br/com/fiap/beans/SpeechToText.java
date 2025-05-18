package br.com.fiap.beans;

public class SpeechToText {
    private String idiomaFalado;
    private String idiomaEscrito;

    public SpeechToText() {
        super();
    }

    public SpeechToText(String idiomaFalado, String idiomaEscrito) {
        this.idiomaFalado = idiomaFalado;
        this.idiomaEscrito = idiomaEscrito;
    }

    public String getIdiomaFalado() {
        return idiomaFalado;
    }

    public void setIdiomaFalado(String idiomaFalado) {
        this.idiomaFalado = idiomaFalado;
    }

    public String getIdiomaEscrito() {
        return idiomaEscrito;
    }

    public void setIdiomaEscrito(String idiomaEscrito) {
        this.idiomaEscrito = idiomaEscrito;
    }

    @Override
    public String toString() {
        return "SpeechToText:" +
                "\nidiomaFalado='" + idiomaFalado + '\'' +
                "\nidiomaEscrito='" + idiomaEscrito + '\'' +
                '.';
    }
}
