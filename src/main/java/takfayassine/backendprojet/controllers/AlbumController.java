package takfayassine.backendprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import takfayassine.backendprojet.models.Album;
import takfayassine.backendprojet.models.Client;
import takfayassine.backendprojet.models.ClientDTO;
import takfayassine.backendprojet.repositories.AlbumRepository;
import takfayassine.backendprojet.repositories.ClientRepository;
import takfayassine.backendprojet.services.AlbumService;

import java.util.List;

@RestController
@RequestMapping("/album")
@CrossOrigin
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AlbumService albumService;


    @PostMapping("/createAlbum/{username}/{albumName}")
    public boolean createAlbum(@PathVariable String username, @PathVariable String albumName){
        Album album = new Album();
        album.setName(albumName);
        album.setClient(clientRepository.findClientByUsername(username));
        albumRepository.save(album);
        return true;

    }

    @PostMapping("/getAllAlbum/{username}")
    public List<Album> getAllAlbum(@PathVariable String username) {
        return albumService.getAllAlbums(username);
    }



//
//    @GetMapping("/getAllAlbum")
//    public List<Album> getAllAlbum(){
//        return albumRepository.findAll();
//    }


}
