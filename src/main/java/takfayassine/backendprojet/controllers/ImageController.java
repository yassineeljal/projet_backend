package takfayassine.backendprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import takfayassine.backendprojet.models.*;
import takfayassine.backendprojet.services.ImageService;

import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/addImageToAlbum")
    public boolean addImageToAlbum(@RequestBody FetchImageAlbum userData) {
        return imageService.addImageToAlbum(userData);
    }

    @PostMapping("/addImageToLiked")
    public boolean addImageToLiked(@RequestBody FetchImageLiked userData) {
        return imageService.addImageToLiked(userData);
    }
    @PostMapping("/getImageInAlbum/{selectedAlbum}")
    public List<Image> getImageInAlbum(@PathVariable String selectedAlbum) {
        return imageService.getImageInAlbum(selectedAlbum);
    }

    @PostMapping("/getImageInLiked/{username}")
    public List<Image> getImageInLiked(@PathVariable String username) {
        return imageService.getImageInLiked(username);
    }
}
