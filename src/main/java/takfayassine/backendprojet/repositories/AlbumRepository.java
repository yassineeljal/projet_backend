package takfayassine.backendprojet.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import takfayassine.backendprojet.models.Album;
import takfayassine.backendprojet.models.Client;

import java.util.List;


public interface AlbumRepository extends JpaRepository<Album,Long> {

    Album findByAlbumId(Long albumId);
    Album findByAlbumName(String albumName);



    public List<Album> findAlbumByAlbumId(Long albumId);

    List<Album> findAlbumByName(String name);
}
