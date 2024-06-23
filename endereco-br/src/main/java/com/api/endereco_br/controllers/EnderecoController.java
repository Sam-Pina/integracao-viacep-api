package com.api.endereco_br.controllers;

import com.api.endereco_br.models.EnderecoModel;
import com.api.endereco_br.repositories.EnderecoRepository;
import com.api.endereco_br.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/endereco")
public class EnderecoController {

    final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @Autowired
    private EnderecoRepository repository;

    @GetMapping
    public ResponseEntity consultaCep(@RequestBody EnderecoModel enderecoModel){
        return ResponseEntity.ok(enderecoService.executar(enderecoModel));
    }
}
