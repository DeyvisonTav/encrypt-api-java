package deyvisontav.com.encryptapi.controllers;

import deyvisontav.com.encryptapi.domain.user.User;
import deyvisontav.com.encryptapi.dto.UserDTO;
import deyvisontav.com.encryptapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO) {
        User newUser = service.create(userDTO);
        return ResponseEntity.ok(newUser);
    }
}
