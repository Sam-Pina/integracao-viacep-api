package com.api.endereco_br.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TB_PESSOA")
public class PessoaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String dataNascimento;
    @Column
    private String idade;
    @Column
    private String sexo;
    @Column
    private String nacionalidade;
    @Column
    private String profissao;
    @Column
    private String hobbie;
    @Column
    private LocalDateTime dataRegristro;
}
