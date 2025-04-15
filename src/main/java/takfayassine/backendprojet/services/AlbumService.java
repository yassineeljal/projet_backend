package takfayassine.backendprojet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takfayassine.backendprojet.models.Album;
import takfayassine.backendprojet.repositories.AlbumRepository;
import takfayassine.backendprojet.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ClientRepository clientRepository;


    public List<Album> getAllAlbums(String username) {
        List<Album> albums = new ArrayList<>();
        clientRepository.findClientByUsername(username);
        for (Album album : albumRepository.findAll()) {
            if (album.getClient().getUsername().equals(username)) {
                albums.add(album);
            }
        }
        return albums;
    }

}
