package com.example.demo2.Service;

import com.example.demo2.Model.Cliente;
import com.example.demo2.Model.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Iterable<Cliente> findAll() {
       return repo.findAll();
    }

    public Cliente findById(Long id) {
        return repo.findById(id).get();
    }

    public Cliente save(Cliente cliente) {
        return repo.save(cliente);
    }

    public  void deleteById(Long id) {
        repo.deleteById(id);
    }


}
