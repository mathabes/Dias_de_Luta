package br.com.fiap.Square.post;
import br.com.fiap.Square.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String titulo;
    String descricao;
    LocalDateTime createdAt;

    @ManyToOne
    User user;
}
