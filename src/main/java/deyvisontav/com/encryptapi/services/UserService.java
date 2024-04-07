package deyvisontav.com.encryptapi.services;

import deyvisontav.com.encryptapi.domain.user.User;
import deyvisontav.com.encryptapi.dto.UserDTO;
import deyvisontav.com.encryptapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    private final EncryptService encryptService;

    public UserService(UserRepository repository, EncryptService encryptService) {
        this.repository = repository;
        this.encryptService = encryptService;
    }

    public User create(UserDTO userDTO) {
        User user = new User();
        String passwordHashed = this.encryptService.encryptData(userDTO.password());
        user.setPassword(passwordHashed);
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        this.repository.save(user);

        return user;
    }

    public User read(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("User not found " + id));

    }
}
