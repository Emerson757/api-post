package com.moots.api_post.repository;

import com.moots.api_post.model.Comentario;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;


public interface ComentarioRepository extends ReactiveNeo4jRepository<Comentario, Long> {
}
