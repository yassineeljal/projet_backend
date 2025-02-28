package yassinetakfa.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yassinetakfa.backend.models.LoginRequest;
import yassinetakfa.backend.models.User;
import yassinetakfa.backend.repositories.LoginRequestRepository;

import java.util.List;

@RestController
@RequestMapping("/pixios")
@CrossOrigin
public class LoginRequestController {
    @Autowired
    LoginRequestRepository loginRequestRepository;

    @PostMapping("/login")
    public LoginRequest createUser(@RequestBody LoginRequest login){
        loginRequestRepository.save(login);

        return login;
    }

}
