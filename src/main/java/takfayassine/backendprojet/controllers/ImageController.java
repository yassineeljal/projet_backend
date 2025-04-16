package takfayassine.backendprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import takfayassine.backendprojet.models.Album;
import takfayassine.backendprojet.models.Bidon;
import takfayassine.backendprojet.models.Image;
import takfayassine.backendprojet.repositories.AlbumRepository;
import takfayassine.backendprojet.repositories.ImageRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @PostMapping("/addImageToAlbum")
    public boolean addImageToAlbum(@RequestBody Bidon userData) {
        String url = userData.getUrl();
        String id = userData.getId();
        Image image = new Image();
        image.setUrl(url);
        image.setAlbum(albumRepository.findAlbumByAlbumId(Long.valueOf(id)));
        imageRepository.save(image);
        return true;

    }
    @PostMapping("/getImageInAlbum/{selectedAlbum}")
    public List<Image> getImageInAlbum(@PathVariable String selectedAlbum) {
        return imageRepository.findImagesByAlbum(albumRepository.findAlbumByName(selectedAlbum));

    }
}
