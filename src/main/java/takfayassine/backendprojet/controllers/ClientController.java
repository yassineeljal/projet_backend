package takfayassine.backendprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import takfayassine.backendprojet.models.*;
import takfayassine.backendprojet.repositories.ClientRepository;
import takfayassine.backendprojet.repositories.ImageRepository;
import takfayassine.backendprojet.repositories.LikedRepository;
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
    @Autowired
    private LikedRepository likedRepository;


    @PostMapping("/createUser")
    public Client createUser(@RequestBody Client client){
        client.setPassword(clientService.registerUser(client.getPassword()));
        Liked liked = new Liked();
        liked.setClient(client);
        clientRepository.save(client);
        likedRepository.save(liked);
        return client;
    }




    @PostMapping("/login/{username}/{pwd}")
    public boolean login(@PathVariable("username") String username, @PathVariable("pwd") String pwd){
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
