package com.moots.api_post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("COMENTARIO")
public class Comentario {

    @Id
    @GeneratedValue
    private Long internalId;

    private String texto;


}
