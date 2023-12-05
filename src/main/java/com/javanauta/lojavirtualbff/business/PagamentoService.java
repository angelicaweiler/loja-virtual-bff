package com.javanauta.lojavirtualbff.business;

import com.javanauta.lojavirtualbff.api.request.CartaoRequestDTO;
import com.javanauta.lojavirtualbff.infrastructure.clients.pagamentoclient.PagamentoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoClient pagamentoClient;

    public Boolean verificaPagamento(CartaoRequestDTO cartaoRequestDTO){
        return pagamentoClient.verificaPagamento(cartaoRequestDTO);
    }
}
