package com.javanauta.lojavirtualbff.api;

import com.javanauta.lojavirtualbff.api.request.CompraRequestDTO;
import com.javanauta.lojavirtualbff.api.request.UsuarioRequestDTO;
import com.javanauta.lojavirtualbff.api.response.ProductsDTO;
import com.javanauta.lojavirtualbff.api.response.UsuarioResponseDTO;
import com.javanauta.lojavirtualbff.business.LojaVirtualService;
import com.javanauta.lojavirtualbff.business.ProdutosService;
import com.javanauta.lojavirtualbff.business.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/loja-virtual")
@RequiredArgsConstructor
@Tag(name = "loja-virtual-api")
public class LojaVirtualController {

    private final ProdutosService produtosService;
    private final UsuarioService usuarioService;
    private final LojaVirtualService lojaVirtualService;

    @Operation(summary = "Busca todos os produtos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/produtos")
    public ResponseEntity<List<ProductsDTO>> buscaTodosProdutos() {
        return ResponseEntity.ok(produtosService.buscaTodosProdutos());
    }

    @Operation(summary = "Busca produtos por nome", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/produtos/{nome}")
    public ResponseEntity<ProductsDTO> buscaProdutosPorNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(produtosService.buscaProdutosPorNome(nome));
    }

    @Operation(summary = "Cadastrar Usuario", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro realizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao cadastrar usuario"),
    })
    @PostMapping("/usuario")
    public ResponseEntity<UsuarioResponseDTO> cadastraUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuarioRequestDTO));
    }

    @Operation(summary = "Deleta usuario por email", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario deletado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar dados"),
    })
    @DeleteMapping("/usuario/{email}")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable("email") String email) {
        usuarioService.deletaUsuarioPorEmail(email);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Realiza compra de produto", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Compra realizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar compra"),
    })
    @PostMapping("/compra")
    public ResponseEntity<String> compraProdutos(@RequestBody CompraRequestDTO compraRequestDTO) {
        return ResponseEntity.ok(lojaVirtualService.realizaCompraProdutos(compraRequestDTO));
    }


}
