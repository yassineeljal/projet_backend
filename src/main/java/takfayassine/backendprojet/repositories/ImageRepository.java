package takfayassine.backendprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import takfayassine.backendprojet.models.Client;
import takfayassine.backendprojet.models.Image;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
