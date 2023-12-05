package com.javanauta.lojavirtualbff.business;

import com.javanauta.lojavirtualbff.api.LojaVirtualController;
import com.javanauta.lojavirtualbff.api.converter.LojaVirtualConverter;
import com.javanauta.lojavirtualbff.api.request.CartaoRequestDTO;
import com.javanauta.lojavirtualbff.api.request.CompraRequestDTO;
import com.javanauta.lojavirtualbff.api.response.ProductsDTO;
import com.javanauta.lojavirtualbff.api.response.UsuarioResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LojaVirtualService {

    private final ProdutosService produtosService;
    private final PagamentoService pagamentoService;
    private final UsuarioService usuarioService;
    private final LojaVirtualConverter converter;

    public String realizaCompraProdutos(CompraRequestDTO compraRequestDTO) {

        UsuarioResponseDTO usuario = buscaDadosUsuario(compraRequestDTO.getEmail());
        ProductsDTO produto = buscaDadosProdutos(compraRequestDTO.getProduto());
        Boolean response = verificaPagamento(usuario, compraRequestDTO, produto);

        return response ? "Pagamento aprovado" : "Pagamento Negado";
    }

    private UsuarioResponseDTO buscaDadosUsuario(String email) {
        return usuarioService.buscaUsuarioPorEmail(email);
    }

    private ProductsDTO buscaDadosProdutos(String nome) {
        return produtosService.buscaProdutosPorNome(nome);
    }

    private Boolean verificaPagamento(UsuarioResponseDTO usuario,
                                      CompraRequestDTO compraRequestDTO, ProductsDTO produto) {
       return pagamentoService.verificaPagamento(converter.paraCartaRequestoDTO(usuario.getNome(),
                compraRequestDTO, produto.getPreco(), usuario.getEndereco()));
    }

}
