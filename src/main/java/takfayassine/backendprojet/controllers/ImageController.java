package takfayassine.backendprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import takfayassine.backendprojet.models.Album;
import takfayassine.backendprojet.models.Image;
import takfayassine.backendprojet.repositories.AlbumRepository;
import takfayassine.backendprojet.repositories.ImageRepository;

import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @PostMapping("/addImageToAlbum/{url}/{albumId}")
    public boolean addImageToAlbum(@PathVariable String url, @PathVariable Long albumId) {
        Image image = new Image();
        image.setUrl(url);
        image.setAlbum(albumRepository.findByAlbumId(albumId));
        imageRepository.save(image);
        return true;

    }
    @PostMapping("/getImageInAlbum/{selectedAlbum}")
    public List<Image> getImageInAlbum(@PathVariable String selectedAlbum) {
        return imageRepository.findImagesByAlbum(albumRepository.findByAlbumName(selectedAlbum));

    }
}
