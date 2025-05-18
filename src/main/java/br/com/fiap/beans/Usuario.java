package br.com.fiap.beans;

public class Usuario {
        private String cpf;
        private String nome;
        private String email;
        private String dataNascimento;
        private Endereco endereco;

    public Usuario() {
        super();
    }
    public Usuario(String cpf, String nome, String email, String dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean validarCPF() {
        String cpfNumerico = this.cpf.replaceAll("\\D", ""); // Remove caracteres não numéricos
        if (cpfNumerico.length() != 11) return false;

        // Implementação simples de validação de CPF
        int soma = 0, peso = 10;
        for (int i = 0; i < 9; i++) {
            soma += (cpfNumerico.charAt(i) - '0') * peso--;
        }
        int resto = (soma * 10) % 11;
        if (resto == 10) resto = 0;
        if (resto != (cpfNumerico.charAt(9) - '0')) return false;

        soma = 0;
        peso = 11;
        for (int i = 0; i < 10; i++) {
            soma += (cpfNumerico.charAt(i) - '0') * peso--;
        }
        resto = (soma * 10) % 11;
        if (resto == 10) resto = 0;

        return resto == (cpfNumerico.charAt(10) - '0');
    }

    @Override
    public String toString() {
        return "Usuário:" +
                "\ncpf='" + cpf + '\'' +
                "\nnome='" + nome + '\'' +
                "\nemail='" + email + '\'' +
                "\ndataNascimento='" + dataNascimento + '\'' +
                "\n" + endereco +
                '.';
    }
}

