package takfayassine.backendprojet.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import takfayassine.backendprojet.models.*;
import takfayassine.backendprojet.repositories.ClientRepository;
import takfayassine.backendprojet.repositories.LikedRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    private final ClientRepository clientRepository;

    @Autowired
    private LikedRepository likedRepository;

    public ClientService(ClientRepository _clientRepository){
        this.clientRepository = _clientRepository;
    }


    public String registerUser(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean login(String username, String frontEndPWD){
        Client user = clientRepository.findClientByUsername(username);
        return passwordEncoder.matches(frontEndPWD, user.getPassword());
    }


    public Client createUser(Client client){
        client.setPassword(registerUser(client.getPassword()));
        Liked liked = new Liked();
        liked.setClient(client);
        clientRepository.save(client);
        likedRepository.save(liked);
        return client;
    }


}
