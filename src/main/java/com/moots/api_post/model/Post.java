package com.moots.api_post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("POST")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String texto;

    private List<String> listImagens;

    @Relationship(type = "CONTEM_COMENTARIOS")
    private List<Comentario> comentarioList;

}
