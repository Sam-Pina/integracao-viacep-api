package com.api.endereco_br.services;

import com.api.endereco_br.models.PessoaModel;
import com.api.endereco_br.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public Object cadastrar(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }

    public List<PessoaModel> getTodasPessoas() {
        return pessoaRepository.findAll();
    }

    public Optional<PessoaModel> getPessoaId(Long id) {
        return pessoaRepository.findById(id);
    }

    @Transactional
    public void deletarPessoa(PessoaModel pessoaModel) {
        pessoaRepository.delete(pessoaModel);
    }
}
