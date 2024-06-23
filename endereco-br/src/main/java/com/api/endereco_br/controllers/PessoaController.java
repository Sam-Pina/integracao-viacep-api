package com.api.endereco_br.controllers;

import com.api.endereco_br.dtos.CadastroPessoaDTO;
import com.api.endereco_br.models.EnderecoRequestModel;
import com.api.endereco_br.repositories.EnderecoRepository;
import com.api.endereco_br.services.EnderecoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoa")
public class EnderecoController {

    final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @Autowired
    private EnderecoRepository repository;

    @GetMapping("/consulta-cep")
    public ResponseEntity consultaCep(@RequestBody EnderecoRequestModel enderecoRequestModel){
        return ResponseEntity.ok(enderecoService.executar(enderecoRequestModel));
    }

    @GetMapping
    public ResponseEntity consultaPessoa(){
        var todasPessoas = repository.findAll();
        return ResponseEntity.ok(todasPessoas);
    }

    @PostMapping
    public ResponseEntity<Object> cadastraPessoa(@RequestBody @Valid CadastroPessoaDTO cadastroPessoaDTO){
        var enderecoRequestModel = new EnderecoRequestModel();
        BeanUtils.copyProperties(cadastroPessoaDTO,enderecoRequestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.cadastrar(enderecoRequestModel));
    }
}
