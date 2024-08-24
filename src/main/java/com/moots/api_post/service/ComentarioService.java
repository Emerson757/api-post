package com.moots.api_post.service;

import com.moots.api_post.dto.ComentarioDTO;
import com.moots.api_post.model.Comentario;
import com.moots.api_post.repository.ComentarioRepository;
import com.moots.api_post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;


    public Mono<Comentario> criarComentario(ComentarioDTO comentarioDTO) {
        var comentario = new Comentario();
        comentario.setTexto(comentarioDTO.texto());
        return comentarioRepository.save(comentario);

    }

    public Mono<Comentario> deletarComentario(Long comentarioId){
        var comentario = comentarioRepository.findById(comentarioId);

        comentarioRepository.deleteById(comentarioId);
        return comentario;
    }

    public Flux<Comentario> acharTodosComentarios(){
        return comentarioRepository.findAll();
    }
}
