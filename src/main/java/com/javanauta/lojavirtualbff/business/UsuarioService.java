package com.javanauta.lojavirtualbff.business;

import com.javanauta.lojavirtualbff.api.request.UsuarioRequestDTO;
import com.javanauta.lojavirtualbff.api.response.UsuarioResponseDTO;
import com.javanauta.lojavirtualbff.infrastructure.clients.usuarioclient.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioClient.gravaDadosUsuario(usuarioRequestDTO);
    }

    public UsuarioResponseDTO buscaUsuarioPorEmail(String email) {
        return usuarioClient.buscaUsuarioPorEmail(email);
    }

    public void deletaUsuarioPorEmail(String email) {
        usuarioClient.deletaDadosUsuario(email);
    }
}
