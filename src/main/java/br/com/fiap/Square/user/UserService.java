package br.com.fiap.Square.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> findByName(String nome){
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public User create(User user){
        user.setSenha(
                passwordEncoder.encode(user.getSenha())
        );
        user.setAvatar("https://avatar.iran.liara.run/username?username=" + user.getNome());
        return repository.save(user);
    }

    public User getUserProfile(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}