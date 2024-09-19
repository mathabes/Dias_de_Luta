package br.com.fiap.Square.post.dto;


import br.com.fiap.Square.post.Post;
import br.com.fiap.Square.user.User;

import java.time.LocalDateTime;

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
