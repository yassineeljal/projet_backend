package takfayassine.backendprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import takfayassine.backendprojet.models.Client;
import takfayassine.backendprojet.models.ClientDTO;
import takfayassine.backendprojet.repositories.ClientRepository;
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


    @PostMapping("/createUser")
    public Client createUser(@RequestBody Client client){
        clientRepository.save(client);
        return client;
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
