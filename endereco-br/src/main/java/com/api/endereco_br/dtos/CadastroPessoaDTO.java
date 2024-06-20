package com.api.endereco_br.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CadastroPessoaDTO {

    @NotBlank
    @Size(max = 8)
    private String cep;
    @NotBlank
    private String nacionalidade;
    @NotBlank
    private String nome;
    @NotBlank
    private String idade;
    @NotBlank
    private String profissao;
}
