package com.api.endereco_br.models;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Entity
@Table(name = "TB_ENDERECO")
public class EnderecoRequestModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 8)
    private String cep;

    //cadastro dados da pessoa
}
