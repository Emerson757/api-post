package com.moots.api_post.controller;

import com.moots.api_post.dto.PostDTO;
import com.moots.api_post.model.Post;
import com.moots.api_post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping(value = "/post-stream-sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<Flux<Post>> streamEvents(Post post) {
        var posts = postService.findAllStream();
        return ResponseEntity.ok().body(posts);
    }

    @PostMapping("/criar-post")
    public ResponseEntity<Mono<Post>> criarPost(@RequestBody PostDTO postDTO){
        var postCriado = postService.criarPost(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(postCriado);
    }


    @DeleteMapping("/deletar-post/{id}")
    public ResponseEntity<Mono<Post>> deletarPost(@PathVariable Long postId){
        var postDeletado = postService.deletarPorId(postId);
        return ResponseEntity.ok().body(postDeletado);
    }

    @GetMapping("/posts")
    public ResponseEntity<Flux<Post>> encontrarTodosPosts(){
        var posts = postService.findAll();
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/encontrar-post/{postId}")
    public ResponseEntity<Mono<Post>> encontrarPost(@PathVariable Long postId){
        var post = postService.findPostAndComentarios(postId);
        return ResponseEntity.ok().body(post);
    }
}
