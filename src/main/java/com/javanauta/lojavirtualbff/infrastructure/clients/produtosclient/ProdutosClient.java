package com.javanauta.lojavirtualbff.infrastructure.clients.produtosclient;

import com.javanauta.lojavirtualbff.api.request.UsuarioRequestDTO;
import com.javanauta.lojavirtualbff.api.response.ProductsDTO;
import com.javanauta.lojavirtualbff.api.response.UsuarioResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "produtos-api", url = "localhost:8181")
public interface ProdutosClient {


    @GetMapping("/produtos/")
    List<ProductsDTO> buscaTodosProdutos();

    @GetMapping("/produtos/{nome}")
    ProductsDTO buscaProdutoPorNome(@PathVariable ("nome") String nome);


}
