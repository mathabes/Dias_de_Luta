package br.com.fiap.Square.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public List<User> findByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user, UriComponentsBuilder uriBuilder) {
        var userProfile = service.create(user);

        var uri = uriBuilder
                .path("/users/{id}")
                .buildAndExpand(userProfile.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(userProfile);
    }

    @GetMapping("profile")
    public User getUserProfile() {
        var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return service.getUserProfile(email);
    }
}
