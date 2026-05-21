package com.example.atvdPontuada.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class FuncionarioRequestDTO {
    @NotBlank(message = "Informe seu nome: ")
    private String nome;

    @NotBlank(message = "Informe seu cpf: ")
    private String cpf;

    @NotBlank(message = "Informe seu email: ")
    @Email(message = "Deve ser um email válido")
    private String email;

    @NotBlank(message = "Informe seu telefone: ")
    private String telefone;

    @NotBlank(message = "Informe seu setor: ")
    private String setor;

    @NotBlank(message = "Informe seu salário: ")
    private Double salario;

    public FuncionarioRequestDTO() {
    }

    public FuncionarioRequestDTO(String nome, String cpf, String email, String telefone, String setor, Double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.setor = setor;
        this.salario = salario;
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

    public @NotBlank(message = "Informe seu email: ") @Email(message = "Deve ser um email válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Informe seu email: ") @Email(message = "Deve ser um email válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Informe seu telefone: ") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "Informe seu telefone: ") String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "Informe seu setor: ") String getSetor() {
        return setor;
    }

    public void setSetor(@NotBlank(message = "Informe seu setor: ") String setor) {
        this.setor = setor;
    }

    public @NotBlank(message = "Informe seu salário: ") Double getSalario() {
        return salario;
    }

    public void setSalario(@NotBlank(message = "Informe seu salário: ") Double salario) {
        this.salario = salario;
    }
}
