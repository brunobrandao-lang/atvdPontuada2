package com.example.atvdPontuada.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    @NotNull(message = "Informe seu salário: ")
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
