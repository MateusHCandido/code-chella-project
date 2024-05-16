package br.com.alura.codechella.domain;

import br.com.alura.codechella.domain.entities.usuario.Endereco;

import java.time.LocalDate;


public class Usuario {
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;

    private Endereco endereco;


    public Usuario(String cpf, String nome, LocalDate nascimento, String email) {
        validarCpf(cpf);

        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    public void validarCpf(String cpf){
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("Cpf no padrão incorreto!");
        }
    }

    public void alterarEmailECpf(String email, String cpf){
        validarCpf(cpf);
        this.cpf = cpf;
        this.email = email;
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void definirEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void alterarCpf(String cpf) {
        validarCpf(cpf);
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }


    public String getEmail() {
        return email;
    }

    public void alterarEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
