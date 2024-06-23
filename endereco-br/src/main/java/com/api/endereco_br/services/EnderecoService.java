package com.api.endereco_br.services;

import com.api.endereco_br.feign.EnderecoFeign;
import com.api.endereco_br.models.EnderecoModel;
import com.api.endereco_br.models.EnderecoModelResponse;
import com.api.endereco_br.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    final EnderecoRepository enderecoRepository;

    final EnderecoFeign enderecoFeign;

    public EnderecoService(EnderecoRepository enderecoRepository, EnderecoFeign enderecoFeign){
        this.enderecoRepository = enderecoRepository;
        this.enderecoFeign = enderecoFeign;
    }

    public EnderecoModelResponse executar(EnderecoModel request){
        return enderecoFeign.buscarEndereco(request.getCep());
    }
}
