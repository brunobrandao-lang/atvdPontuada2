package com.example.atvdPontuada.service;

import com.example.atvdPontuada.dtos.FornecedorRequestDTO;
import com.example.atvdPontuada.dtos.FornecedorResponseDTO;
import com.example.atvdPontuada.model.FornecedorModel;
import com.example.atvdPontuada.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    public List<FornecedorResponseDTO> listarTodos(){
        return repository
                .findAll()
                .stream()
                .map(fornecedor -> new FornecedorResponseDTO(
                        fornecedor.getNome(),
                        fornecedor.getEmail(),
                        fornecedor.getTelefone()))
                .toList();
    }

    public FornecedorModel salvar(FornecedorRequestDTO dto){
        if (repository.findByCnpj(dto.getCnpj()).isPresent()){
            throw new RuntimeException("Fornecedor já cadastrado.");
        }
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado.");
        }
        FornecedorModel novoFornecedor = new FornecedorModel();
        novoFornecedor.setNome(dto.getNome());
        novoFornecedor.setCnpj(dto.getCnpj());
        novoFornecedor.setEmail(dto.getEmail());
        novoFornecedor.setTelefone(dto.getTelefone());

        return repository.save(novoFornecedor);
    }

    public void atualizar(Long id, FornecedorRequestDTO dto){
        FornecedorModel fornecedor = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Fornecedor não encontrado."));

        repository.findByCnpj(dto.getCnpj()).ifPresent(f -> {
            if (!f.getId().equals(id)) {
                throw new RuntimeException("CNPJ já cadastrado por outro fornecedor.");
            }
        });

        repository.findByEmail(dto.getEmail()).ifPresent(f -> {
            if (!f.getId().equals(id)) {
                throw new RuntimeException("E-mail já cadastrado por outro fornecedor.");
            }
        });

        fornecedor.setNome(dto.getNome());
        fornecedor.setCnpj(dto.getCnpj());
        fornecedor.setEmail(dto.getEmail());
        fornecedor.setTelefone(dto.getTelefone());

        repository.save(fornecedor);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Fornecedor não encontrado.");
        }
        repository.deleteById(id);
    }
}