package com.example.atvdPontuada.repository;

import com.example.atvdPontuada.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
    Optional<FuncionarioModel>findByCpf(String cpf);
    Optional<FuncionarioModel> findByEmail(String email);
}
