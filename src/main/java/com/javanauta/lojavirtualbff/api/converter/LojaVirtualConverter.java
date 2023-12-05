package com.javanauta.lojavirtualbff.api.converter;

import com.javanauta.lojavirtualbff.api.request.CartaoRequestDTO;
import com.javanauta.lojavirtualbff.api.request.CompraRequestDTO;
import com.javanauta.lojavirtualbff.api.request.EnderecoRequestDTO;
import com.javanauta.lojavirtualbff.api.response.EnderecoResponseDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LojaVirtualConverter {

    public CartaoRequestDTO paraCartaRequestoDTO(String nome, CompraRequestDTO compraRequestDTO, BigDecimal valor,
                                          EnderecoResponseDTO enderecoResponseDTO) {

        return CartaoRequestDTO.builder()
                .nome(nome)
                .enderecoRequestDTO(paraEnderecoRequestDTO(enderecoResponseDTO))
                .numeroCartao(compraRequestDTO.getNumeroCartao())
                .ano(compraRequestDTO.getAno())
                .mes(compraRequestDTO.getMes())
                .cvv(compraRequestDTO.getAno())
                .valor(valor)
                .build();

    }

    private EnderecoRequestDTO paraEnderecoRequestDTO(EnderecoResponseDTO enderecoResponseDTO) {
        return EnderecoRequestDTO.builder()
                .bairro(enderecoResponseDTO.getBairro())
                .cep(enderecoResponseDTO.getCep())
                .cidade(enderecoResponseDTO.getCidade())
                .complemento(enderecoResponseDTO.getComplemento())
                .numero(enderecoResponseDTO.getNumero())
                .rua(enderecoResponseDTO.getRua())
                .build();
    }
}
