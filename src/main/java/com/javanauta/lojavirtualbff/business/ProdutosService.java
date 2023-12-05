package com.javanauta.lojavirtualbff.business;

import com.javanauta.lojavirtualbff.api.response.ProductsDTO;
import com.javanauta.lojavirtualbff.infrastructure.clients.produtosclient.ProdutosClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutosService {

    private final ProdutosClient client;

    public List<ProductsDTO> buscaTodosProdutos() {
        return client.buscaTodosProdutos();
    }

    public ProductsDTO buscaProdutosPorNome(String nome) {
        return client.buscaProdutoPorNome(nome);
    }


}
