package takfayassine.backendprojet.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import takfayassine.backendprojet.models.Client;


public interface ClientRepository extends JpaRepository<Client,Long> {
    public Client findClientByUsername(String username);


}
