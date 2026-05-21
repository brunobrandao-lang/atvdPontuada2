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
    private String DataNascimento;

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
        DataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
    }

    public @NotBlank(message = "Informe seu nome: ") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Informe seu nome: ") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Informe seu cpf: ") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "Informe seu cpf: ") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "Informe sua data de nascimento: ") String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(@NotBlank(message = "Informe sua data de nascimento: ") String dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public @NotBlank(message = "Informe seu email: ") @Email(message = "Deve ser um email válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Informe seu email: ") @Email(message = "Deve ser um email válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Crie sua senha: ") @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "Crie sua senha: ") @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres") String senha) {
        this.senha = senha;
    }
}
