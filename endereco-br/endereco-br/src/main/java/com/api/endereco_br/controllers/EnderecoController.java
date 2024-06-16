package com.api.endereco_br.controllers;

import com.api.endereco_br.models.EnderecoRequestModel;
import com.api.endereco_br.services.EnderecoService;
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

    @GetMapping("/consulta")
    public ResponseEntity endereco(@RequestBody EnderecoRequestModel enderecoRequestModel){
        return ResponseEntity.ok(enderecoService.executar(enderecoRequestModel));
    }

}
