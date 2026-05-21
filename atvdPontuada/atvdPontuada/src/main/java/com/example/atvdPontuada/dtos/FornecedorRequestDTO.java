package com.example.atvdPontuada.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class FornecedorRequestDTO {
    @NotBlank(message = "Informe seu nome: ")
    private String nome;

    @NotBlank(message = "Informe o CNPJ: ")
    private String cnpj;

    @NotBlank(message = "Informe seu email: ")
    @Email(message = "Deve ser um email válido")
    private String email;

    @NotBlank(message = "Informe seu telefone: ")
    private String telefone;

    public FornecedorRequestDTO() {
    }

    public FornecedorRequestDTO(String nome, String cnpj, String email, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
    }

    public @NotBlank(message = "Informe seu nome: ") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Informe seu nome: ") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Informe o CNPJ: ") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank(message = "Informe o CNPJ: ") String cnpj) {
        this.cnpj = cnpj;
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
}
