package takfayassine.backendprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import takfayassine.backendprojet.models.*;
import takfayassine.backendprojet.services.ClientService;

@RestController
@RequestMapping("/pixios")
@CrossOrigin
public class ClientController {


    @Autowired
    ClientService clientService;


    @PostMapping("/createUser")
    public Client createUser(@RequestBody Client client){
        return clientService.createUser(client);
    }




    @PostMapping("/login/{username}/{pwd}")
    public boolean login(@PathVariable("username") String username, @PathVariable("pwd") String pwd){
        return clientService.login(username, pwd);
    }

}
