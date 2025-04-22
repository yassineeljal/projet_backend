package takfayassine.backendprojet.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import takfayassine.backendprojet.models.Album;

import java.util.List;


public interface AlbumRepository extends JpaRepository<Album,Long> {

    Album findAlbumByAlbumId(Long albumId);

    Album findAlbumByName(String name);

    List<Album> findAlbumsByName(String name);
}
