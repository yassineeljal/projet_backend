package yassinetakfa.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yassinetakfa.backend.models.LoginRequest;
import yassinetakfa.backend.models.User;
import yassinetakfa.backend.repositories.UserRepository;

@RestController
@RequestMapping("/pixios")
@CrossOrigin
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        userRepository.save(user);
        return user;
    }



}
