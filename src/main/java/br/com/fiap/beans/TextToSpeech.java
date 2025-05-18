package br.com.fiap.beans;

public class TextToSpeech {
    private String idomaTraduzido;
    private String idomaFalado;

    public TextToSpeech() {
        super();
    }

    public TextToSpeech(String idomaTraduzido, String idomaFalado) {
        super();
        this.idomaTraduzido = idomaTraduzido;
        this.idomaFalado = idomaFalado;
    }

    public String getIdomaTraduzido() {
        return idomaTraduzido;
    }

    public void setIdomaTraduzido(String idomaTraduzido) {
        this.idomaTraduzido = idomaTraduzido;
    }

    public String getIdomaFalado() {
        return idomaFalado;
    }

    public void setIdomaFalado(String idomaFalado) {
        this.idomaFalado = idomaFalado;
    }

    @Override
    public String toString() {
        return "TextToSpeech:" +
                "\nidomaTraduzido='" + idomaTraduzido + '\'' +
                "\nidomaFalado='" + idomaFalado + '\'' +
                '.';
    }

}
