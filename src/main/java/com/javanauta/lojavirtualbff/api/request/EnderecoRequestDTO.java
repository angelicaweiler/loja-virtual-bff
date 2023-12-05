package com.javanauta.lojavirtualbff.api.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoRequestDTO {

    private String rua;

    private Long numero;

    private String bairro;

    private String complemento;

    private String cidade;

    private String cep;

}
