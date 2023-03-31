package com.example.demo2.Controller;

import com.example.demo2.Model.Cliente;
import com.example.demo2.Model.Endereco;
import com.example.demo2.Model.EnderecoRepository;
import com.example.demo2.Service.ClienteService;
import com.example.demo2.Service.ViaCepService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;


    @GetMapping("/listar")
    public ResponseEntity<Iterable<Cliente>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return getClienteResponseEntity(cliente);
    }

    private ResponseEntity<Cliente> getClienteResponseEntity(Cliente cliente) {
        String cep  = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco endereco1 = viaCepService.consultaCep(cep);
            enderecoRepository.save(endereco1);
            return endereco1;
          });
        cliente.setEndereco(endereco);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

}
