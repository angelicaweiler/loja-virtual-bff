package com.javanauta.lojavirtualbff.infrastructure.clients.pagamentoclient;

import com.javanauta.lojavirtualbff.api.request.CartaoRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "pagamento-api", url = "localhost:8383")
public interface PagamentoClient {

    @PostMapping("/pagamento")
    Boolean verificaPagamento(@RequestBody CartaoRequestDTO cartaoRequestDTO);


}
