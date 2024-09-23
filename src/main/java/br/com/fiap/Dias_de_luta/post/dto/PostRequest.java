package br.com.fiap.Dias_de_luta.post.dto;


import java.time.LocalDateTime;

import br.com.fiap.Dias_de_luta.post.Post;
import br.com.fiap.Dias_de_luta.user.User;

public record PostRequest(String text) {
    public Post toModel(User user) {
        return Post
                .builder()
                .titulo(text)
                .descricao(text)
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();
    }
}
