package com.quintoimpacto.ecosistema.controller;

import com.quintoimpacto.ecosistema.model.Usuario;
import com.quintoimpacto.ecosistema.service.abstraction.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long usuarioId){
        return new ResponseEntity<>(usuarioService.getUsuario(usuarioId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios(){
        return new ResponseEntity<>(usuarioService.getAllUsuarios(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.createUsuario(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long usuarioId, @RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.updateUsuario(usuarioId, usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long usuarioId){
        usuarioService.deleteUsuario(usuarioId);
        return ResponseEntity.ok().build();
    }
}
