package com.moots.api_post.controller;

import com.moots.api_post.dto.ComentarioDTO;
import com.moots.api_post.model.Comentario;
import com.moots.api_post.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("/criar-comentario")
    public ResponseEntity<Mono<Comentario>> criarComentario(@RequestBody ComentarioDTO comentarioDTO){
        var comentarioCriado = comentarioService.criarComentario(comentarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioCriado);
    }

    @GetMapping("/comentarios")
    public ResponseEntity<Flux<Comentario>> acharComentarios(){
        var comentarios = comentarioService.acharTodosComentarios();
        return ResponseEntity.ok().body(comentarios);
    }

    @DeleteMapping("/deletar-comentario/{id}")
    public ResponseEntity<Mono<Comentario>> deletarComentario(@PathVariable Long comentarioId){
        var comentarioDeletado = comentarioService.deletarComentario(comentarioId);
        return ResponseEntity.ok().body(comentarioDeletado);
    }
}
