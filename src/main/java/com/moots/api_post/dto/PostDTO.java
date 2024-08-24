package com.moots.api_post.dto;

import com.moots.api_post.model.Comentario;

import java.util.List;

public record PostDTO(List<String> listImagens, String texto, List<Comentario> comentarioList) {
}
