package com.example.atvdPontuada.controller;

import com.example.atvdPontuada.dtos.FornecedorRequestDTO;
import com.example.atvdPontuada.dtos.FornecedorResponseDTO;
import com.example.atvdPontuada.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedores") 
public class FornecedorController {
    @Autowired
    FornecedorService service;

    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody FornecedorRequestDTO dto){
        service.salvar(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cadastrado com sucesso."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar (@PathVariable Long id, @RequestBody @Valid FornecedorRequestDTO dto){
        service.atualizar(id, dto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Excluído com sucesso."));
    }
}