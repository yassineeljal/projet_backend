package takfayassine.backendprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import takfayassine.backendprojet.models.Client;
import takfayassine.backendprojet.models.Liked;

public interface LikedRepository extends JpaRepository<Liked,Long> {
    Liked findLikedByClient(Client client);
}
