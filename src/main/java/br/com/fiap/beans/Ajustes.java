package br.com.fiap.beans;

public class Ajustes {
    private int brilho;
    private int tamanhoFonte;
    private String idioma;

    public Ajustes() {
        super();
    }

    public Ajustes(int brilho, int tamanhoFonte, String idioma) {
        this.brilho = brilho;
        this.tamanhoFonte = tamanhoFonte;
        this.idioma = idioma;
    }

    //    public Ajustes(int brilho, int tamanhoFonte, String idioma) {
//        super();
//        setBrilho(brilho);
//        setTamanhoFonte(tamanhoFonte);
//        this.idioma = idioma;
//    }

    public int getBrilho() {
        return brilho;
    }

    public void setBrilho(int brilho) {
        if (brilho < 25) brilho = 25;
        if (brilho > 100) brilho = 100;
        this.brilho = brilho;
    }

    public int getTamanhoFonte() {
        return tamanhoFonte;
    }

    public void setTamanhoFonte(int tamanhoFonte) {
        if (tamanhoFonte < 8) {
            System.out.println("Tamanho da fonte muito pequeno! Ajustando para 8.");
            this.tamanhoFonte = 8; // Ajusta para o mínimo permitido
        } else if (tamanhoFonte > 72) {
            System.out.println("Tamanho da fonte muito grande! Ajustando para 72.");
            this.tamanhoFonte = 72; // Ajusta para o máximo permitido
        } else {
            this.tamanhoFonte = tamanhoFonte; // Mantém o valor se dentro do intervalo
        }
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
       this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Ajustes:" +
                "\nbrilho=" + brilho +
                "\ntamanhoFonte=" + tamanhoFonte +
                "\nidioma do sistema='" + idioma + '\'' +
                '.';
    }
}

