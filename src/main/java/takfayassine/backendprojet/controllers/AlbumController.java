package takfayassine.backendprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import takfayassine.backendprojet.models.Album;
import takfayassine.backendprojet.repositories.AlbumRepository;
import takfayassine.backendprojet.repositories.ClientRepository;
import takfayassine.backendprojet.services.AlbumService;

@RestController
@RequestMapping("/album")
@CrossOrigin
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ClientRepository clientRepository;


    @PostMapping("/createAlbum/{username}/{albumName}")
    public boolean createAlbum(@PathVariable String username, @PathVariable String albumName){
        Album album = new Album();
        album.setName(albumName);
        album.setClient(clientRepository.findClientByUsername(username));
        albumRepository.save(album);
        return true;
    }

}
