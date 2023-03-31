package com.example.demo2.Service;

import com.example.demo2.Model.Endereco;
import com.example.demo2.Model.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json")
    public Endereco consultaCep(@PathVariable("cep") String cep);
}
