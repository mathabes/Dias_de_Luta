package br.com.fiap.Dias_de_luta.post.dto;


import java.time.LocalDateTime;

import br.com.fiap.Dias_de_luta.post.Post;
import br.com.fiap.Dias_de_luta.user.User;

public record PostRequest(String titulo, String descricao) {
    public Post toModel(User user) {
        return Post
                .builder()
                .titulo(titulo)
                .descricao(descricao)
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();
    }
}
