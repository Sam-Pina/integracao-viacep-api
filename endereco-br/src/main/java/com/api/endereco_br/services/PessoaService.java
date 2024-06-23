package com.api.endereco_br.services;

import com.api.endereco_br.feign.EnderecoFeign;
import com.api.endereco_br.models.EnderecoRequestModel;
import com.api.endereco_br.models.EnderecoResponseModel;
import com.api.endereco_br.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnderecoService {

    final EnderecoRepository enderecoRepository;

    final EnderecoFeign enderecoFeign;

    public EnderecoService(EnderecoRepository enderecoRepository, EnderecoFeign enderecoFeign){
        this.enderecoRepository = enderecoRepository;
        this.enderecoFeign = enderecoFeign;
    }

    public EnderecoResponseModel executar(EnderecoRequestModel request){
        return enderecoFeign.buscarEndereco(request.getCep());
    }

    @Transactional
    public EnderecoRequestModel cadastrar(EnderecoRequestModel enderecoRequestModel) {
        return enderecoRepository.save(enderecoRequestModel);
    }

    public Optional<EnderecoRequestModel> findById(UUID id){
        return enderecoRepository.findById(id);
    }
}
