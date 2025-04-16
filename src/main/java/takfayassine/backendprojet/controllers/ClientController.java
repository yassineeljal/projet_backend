package takfayassine.backendprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import takfayassine.backendprojet.models.Album;
import takfayassine.backendprojet.models.Client;
import takfayassine.backendprojet.models.ClientDTO;
import takfayassine.backendprojet.models.Image;
import takfayassine.backendprojet.repositories.ClientRepository;
import takfayassine.backendprojet.repositories.ImageRepository;
import takfayassine.backendprojet.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/pixios")
@CrossOrigin
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    ImageRepository imageRepository;




    @PostMapping("/createUser")
    public Client createUser(@RequestBody Client client){
        client.setPassword(clientService.registerUser(client.getPassword()));
        clientRepository.save(client);
        return client;
    }




    @PostMapping("/login/{username}/{pwd}")
    public boolean login(@PathVariable String username, @PathVariable String pwd){
        return clientService.login(username, pwd);
    }


    @PostMapping("/profile/{username}/{pwd}")
    public List<String> profile(@PathVariable String username, @PathVariable String pwd){
        return clientService.getClientInfo(username);
    }

    @GetMapping("/get1")
    public List<ClientDTO> getAllDTO(){
        return clientService.getAllClient();
    }

    @GetMapping("/get2")
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }





}
