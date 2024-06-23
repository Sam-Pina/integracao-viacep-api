package com.api.endereco_br.controllers;

import com.api.endereco_br.dtos.PessoaDTO;
import com.api.endereco_br.models.PessoaModel;
import com.api.endereco_br.services.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoa")
public class PessoaController {

    final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastroPessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
        var pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDTO, pessoaModel);
        pessoaModel.setDataRegristro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.cadastrar(pessoaModel));
    }

    @GetMapping
    public ResponseEntity<List<PessoaModel>> consultarTodasPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getTodasPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> consultaPessoaId(@PathVariable (value = "id") Long id){
        Optional<PessoaModel> pessoaModelOptional = pessoaService.getPessoaId(id);
        if(!pessoaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa nao encontrada");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaPessoaId(@PathVariable (value = "id") Long id){
        Optional<PessoaModel> pessoaModelOptional = pessoaService.getPessoaId(id);
        if(!pessoaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa nao encontrada");
        }
        pessoaService.deletarPessoa(pessoaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPessoaId(@PathVariable (value = "id") Long id,
                                                    @RequestBody @Valid PessoaDTO pessoaDTO){
        Optional<PessoaModel> pessoaModelOptional = pessoaService.getPessoaId(id);
        if(!pessoaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa nao encontrada");
        }
        var pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDTO, pessoaModel);
        pessoaModel.setId(pessoaModelOptional.get().getId());
        pessoaModel.setDataRegristro(pessoaModelOptional.get().getDataRegristro());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.cadastrar(pessoaModel));
    }
}
