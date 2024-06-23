package com.api.endereco_br.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String dataNascimento;
    @NotBlank
    private String idade;
    @NotBlank
    private String sexo;
    @NotBlank
    private String profissao;
    @NotBlank
    private String nacionalidade;
    @NotBlank
    private String hobbie;
}
