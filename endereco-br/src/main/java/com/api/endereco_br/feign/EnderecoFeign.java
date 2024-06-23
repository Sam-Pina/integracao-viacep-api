package com.api.endereco_br.feign;

import com.api.endereco_br.models.EnderecoModelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface EnderecoFeign {

    @GetMapping("{cep}/json")
    EnderecoModelResponse buscarEndereco(@PathVariable("cep") String cep);
}
