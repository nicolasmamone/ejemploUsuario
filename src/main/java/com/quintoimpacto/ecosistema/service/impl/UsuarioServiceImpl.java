package com.quintoimpacto.ecosistema.service.impl;

import com.quintoimpacto.ecosistema.model.Usuario;
import com.quintoimpacto.ecosistema.repository.UsuarioRepository;
import com.quintoimpacto.ecosistema.service.abstraction.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService { //TODO: Implementar modelMapper
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario getUsuario(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new EntityNotFoundException("El usuario con id: " + usuarioId + " no existe en base de datos"));
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        Usuario usuarioSave = new Usuario();
        usuarioSave.setNombre(usuario.getNombre());
        usuarioSave.setApellido(usuario.getApellido());
        usuarioSave.setMail(usuario.getMail());
        usuarioSave.setTelefono(usuario.getTelefono());
        usuarioSave.setRol(usuario.getRol());
        return usuarioRepository.save(usuarioSave);
    }

    @Override
    public Usuario updateUsuario(Long usuarioId, Usuario usuario) {
        Usuario usuarioUpdate = usuarioRepository.findById(usuarioId).orElseThrow(() -> new EntityNotFoundException("El usuario con id: " + usuarioId + " no existe en base de datos"));
        if (usuarioUpdate != null){
            usuarioUpdate.setNombre(usuario.getNombre());
            usuarioUpdate.setApellido(usuario.getApellido());
            usuarioUpdate.setMail(usuario.getMail());
            usuarioUpdate.setTelefono(usuario.getTelefono());
            usuarioUpdate.setRol(usuario.getRol());
            usuarioRepository.save(usuarioUpdate);
        }
        return usuarioUpdate; // TODO: devolver un UsuarioDTO
    }

    @Override
    public void deleteUsuario(Long usuarioId) {
        Usuario usuarioDelete = usuarioRepository.findById(usuarioId).orElseThrow(() -> new EntityNotFoundException("El usuario con id: " + usuarioId + " no existe en base de datos"));
        usuarioDelete.setDeleted(true);
        usuarioRepository.save(usuarioDelete);
    }
}
