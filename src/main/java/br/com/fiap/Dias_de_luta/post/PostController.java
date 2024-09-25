package br.com.fiap.Dias_de_luta.post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.Dias_de_luta.post.dto.PostRequest;
import br.com.fiap.Dias_de_luta.user.UserRepository;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final UserRepository userRepository;

    public PostController(PostService postService, UserRepository userRepository) {
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public Page<Post> findAll(@PageableDefault(size = 5) Pageable pageable){
        return postService.findAll(pageable);
    }

    @PostMapping
    public Post create(@RequestBody PostRequest postRequest){
        var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        var user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );
        Post post = postRequest.toModel(user);
        return postService.create(post);
    }

}
