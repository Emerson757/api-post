package com.moots.api_post.service;

import com.moots.api_post.dto.PostDTO;
import com.moots.api_post.model.Post;
import com.moots.api_post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.NoSuchElementException;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Mono<Post> criarPost(PostDTO postDTO){

        var post = new Post();
        post.setListImagens(postDTO.listImagens());
        post.setTexto(postDTO.texto());
        post.setComentarioList(postDTO.comentarioList());

        return postRepository.save(post);

    }

    public Mono<Post> acharPorId(Long postId){
        return postRepository.findById(postId)
                .switchIfEmpty(Mono.error(NoSuchElementException::new));
    }

    public Mono<Post> deletarPorId(Long postId){
        var post = postRepository.findById(postId)
                .switchIfEmpty(Mono.error(NoSuchElementException::new));

        postRepository.deleteById(postId);

        return post;
    }

    public Flux<Post> findAllStream(){
        Flux<Long> intervalo = Flux.interval(Duration.ofSeconds(1));
        Flux<Post> data = Flux.from(postRepository.findAll());

        return Flux.zip(data, intervalo, (key, value) -> key);
    }

    public Flux<Post> findAll(){
        return postRepository.findAll();
    }

    public Mono<Post> findPostAndComentarios(Long postId){
        return postRepository.encontrarPostEComentarios(postId);
    }

}
