package com.example.atvdPontuada.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClienteRequestDTO {
    @NotBlank(message = "Informe seu nome: ")
    private String nome;

    @NotBlank(message = "Informe seu cpf: ")
    private String cpf;

    @NotBlank(message = "Informe sua data de nascimento: ")
    private String dataNascimento;

    @NotBlank(message = "Informe seu email: ")
    @Email(message = "Deve ser um email válido")
    private String email;

    @NotBlank(message = "Crie sua senha: ")
    @Size (min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nome, String cpf, String dataNascimento, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
