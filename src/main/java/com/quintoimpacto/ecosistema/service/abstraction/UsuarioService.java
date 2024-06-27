package com.quintoimpacto.ecosistema.service.abstraction;

import com.quintoimpacto.ecosistema.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario getUsuario(Long usuarioId);
    List<Usuario> getAllUsuarios();
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Long usuarioId, Usuario usuario);
    void deleteUsuario(Long usuarioId);
}
