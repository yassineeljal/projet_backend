package takfayassine.backendprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import takfayassine.backendprojet.models.*;
import takfayassine.backendprojet.repositories.AlbumRepository;
import takfayassine.backendprojet.repositories.ClientRepository;
import takfayassine.backendprojet.repositories.ImageRepository;
import takfayassine.backendprojet.repositories.LikedRepository;

import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LikedRepository likedRepository;

    @PostMapping("/addImageToAlbum")
    public boolean addImageToAlbum(@RequestBody FetchImageAlbum userData) {
        String url = userData.getUrl();
        String id = userData.getId();
        Image image = new Image();
        image.setUrl(url);
        image.setAlbum(albumRepository.findAlbumByAlbumId(Long.valueOf(id)));
        imageRepository.save(image);
        return true;

    }

    @PostMapping("/addImageToLiked")
    public boolean addImageToLiked(@RequestBody FetchImageLiked userData) {
        String url = userData.getUrl();
        String username = userData.getUsername();
        Image image = new Image();
        image.setUrl(url);
        image.setLiked(likedRepository.findLikedByClient(clientRepository.findClientByUsername(username)));
        imageRepository.save(image);
        return true;

    }
    @PostMapping("/getImageInAlbum/{selectedAlbum}")
    public List<Image> getImageInAlbum(@PathVariable String selectedAlbum) {
        return imageRepository.findImagesByAlbum(albumRepository.findAlbumByName(selectedAlbum));

    }

    @PostMapping("/getImageInLiked/{username}")
    public List<Image> getImageInLiked(@PathVariable String username) {
        return imageRepository.findImagesByLiked(likedRepository.findLikedByClient(clientRepository.findClientByUsername(username)));

    }
}
