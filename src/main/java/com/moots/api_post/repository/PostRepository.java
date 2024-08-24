package com.moots.api_post.repository;

import com.moots.api_post.model.Post;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostRepository extends ReactiveNeo4jRepository<Post, Long> {


    @Query("MATCH (p:POST)-[:CONTEM_COMENTARIOS]->(c:COMENTARIO) WHERE p.id = $postId RETURN p, collect(c) as comentarios")
    Mono<Post> encontrarPostEComentarios(Long postId);
}
