package com.example.atvdPontuada.dtos;

public class ClienteResponseDTO {
    private String nome;
    private String DataNascimento;
    private String email;

    public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(String nome, String dataNascimento, String email) {
        this.nome = nome;
        DataNascimento = dataNascimento;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
