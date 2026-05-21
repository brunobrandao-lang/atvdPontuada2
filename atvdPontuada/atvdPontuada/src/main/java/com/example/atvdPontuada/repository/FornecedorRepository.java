package com.example.atvdPontuada.repository;

import com.example.atvdPontuada.model.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {
    Optional<FornecedorModel>findByCnpj(String cnpj);
    Optional<FornecedorModel> findByEmail(String email);
}
