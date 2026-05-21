package com.example.atvdPontuada.service;

import com.example.atvdPontuada.dtos.ClienteRequestDTO;
import com.example.atvdPontuada.dtos.ClienteResponseDTO;
import com.example.atvdPontuada.model.ClienteModel;
import com.example.atvdPontuada.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<ClienteResponseDTO> listarTodos(){
        return repository
                .findAll()
                .stream()
                .map(cliente -> new ClienteResponseDTO(
                        cliente.getNome(),
                        cliente.getDataNascimento(),
                        cliente.getEmail()))
                .toList();
    }

    public ClienteModel salvarCliente (ClienteRequestDTO dto) {
        if (repository.findByCpf(dto.getCpf()).isPresent()) {
            throw new RuntimeException("Cliente já cadastrado.");
        }
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado.");
        }
        ClienteModel novoCliente = new ClienteModel();
        novoCliente.setNome(dto.getNome());
        novoCliente.setCpf(dto.getCpf());
        novoCliente.setDataNascimento(dto.getDataNascimento());
        novoCliente.setEmail(dto.getEmail());
        novoCliente.setSenha(passwordEncoder.encode(dto.getSenha()));

        return repository.save(novoCliente);
    }

    public void atualizar(Long id, ClienteRequestDTO dto){
        ClienteModel cliente = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Cliente não encontrado."));

        repository.findByCpf(dto.getCpf()).ifPresent(c -> {
            if (!c.getId().equals(id)) {
                throw new RuntimeException("CPF já cadastrado por outro cliente.");
            }
        });

        repository.findByEmail(dto.getEmail()).ifPresent(c -> {
            if (!c.getId().equals(id)) {
                throw new RuntimeException("E-mail já cadastrado por outro cliente.");
            }
        });

        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(passwordEncoder.encode(dto.getSenha()));

        repository.save(cliente);
    }

    public void excluir(Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado.");
        }
        repository.deleteById(id);
    }
}