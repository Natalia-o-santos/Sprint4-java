package br.com.fiap.beans;

public class AudioGuia {
    private int volume;
    private String idioma;

    public AudioGuia() {
        super();
    }

    public AudioGuia(String idioma, int volume) {
        this.idioma = idioma;
        setVolume(volume);
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {

        if (volume >= 0 && volume <= 100) {

            this.volume = volume;

            System.out.println("Volume ajustado para: " + volume);

        } else {

            System.out.println("Erro: O volume deve estar entre 0 e 100.");

        }
    }

    @Override
    public String toString() {
        return "AudioGuia:" +
                "\nvolume=" + volume +
                "\nidioma='" + idioma + '\'';
    }
}




