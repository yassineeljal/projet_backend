package takfayassine.backendprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import takfayassine.backendprojet.models.Album;
import takfayassine.backendprojet.models.Image;
import takfayassine.backendprojet.models.Liked;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findImagesByAlbum(Album album);

    List<Image> findImagesByLiked(Liked liked);
}
