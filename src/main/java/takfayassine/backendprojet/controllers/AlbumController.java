package takfayassine.backendprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import takfayassine.backendprojet.models.Album;

import takfayassine.backendprojet.services.AlbumService;

import java.util.List;

@RestController
@RequestMapping("/album")
@CrossOrigin
public class AlbumController {


    @Autowired
    AlbumService albumService;


    @PostMapping("/createAlbum/{username}/{albumName}")
    public boolean createAlbum(@PathVariable String username, @PathVariable String albumName){
        return albumService.createAlbum(username,albumName);
    };

    @PostMapping("/getAllAlbum/{username}")
    public List<Album> getAllAlbum(@PathVariable String username) {
        return albumService.getAllAlbums(username);
    }



}
