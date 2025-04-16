package takfayassine.backendprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import takfayassine.backendprojet.models.Album;
import takfayassine.backendprojet.models.Image;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findImagesByAlbum(Album album);
}
