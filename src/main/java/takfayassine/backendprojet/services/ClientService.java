package takfayassine.backendprojet.services;
import org.springframework.stereotype.Service;
import takfayassine.backendprojet.models.Client;
import takfayassine.backendprojet.models.ClientDTO;
import takfayassine.backendprojet.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository _clientRepository){
        this.clientRepository = _clientRepository;
    }

    public List<ClientDTO> getAllClient(){
        List<Client> list = clientRepository.findAll();
        List<ClientDTO> listDTO = new ArrayList<>();

        for (Client c: list){
            ClientDTO cdto = new ClientDTO();
            cdto.setEmail(c.getEmail());
            cdto.setFirstname(c.getFirstname());
            cdto.setLastname(c.getLastname());

            listDTO.add(cdto);
        }
        return listDTO;
    }
}
