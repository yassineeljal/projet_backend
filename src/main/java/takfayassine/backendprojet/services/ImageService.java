package takfayassine.backendprojet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takfayassine.backendprojet.models.FetchImageAlbum;
import takfayassine.backendprojet.models.FetchImageLiked;
import takfayassine.backendprojet.models.Image;
import takfayassine.backendprojet.repositories.AlbumRepository;
import takfayassine.backendprojet.repositories.ClientRepository;
import takfayassine.backendprojet.repositories.ImageRepository;
import takfayassine.backendprojet.repositories.LikedRepository;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private LikedRepository likedRepository;


    public boolean addImageToAlbum(FetchImageAlbum userData) {
        String url = userData.getUrl();
        String id = userData.getId();
        Image image = new Image();
        image.setUrl(url);
        image.setAlbum(albumRepository.findAlbumByAlbumId(Long.valueOf(id)));
        imageRepository.save(image);
        return true;

    }

    public boolean addImageToLiked(FetchImageLiked userData) {
        String url = userData.getUrl();
        String username = userData.getUsername();
        Image image = new Image();
        image.setUrl(url);
        image.setLiked(likedRepository.findLikedByClient(clientRepository.findClientByUsername(username)));
        imageRepository.save(image);
        return true;

    }

    public List<Image> getImageInAlbum(String selectedAlbum) {
        return imageRepository.findImagesByAlbum(albumRepository.findAlbumByName(selectedAlbum));

    }

    public List<Image> getImageInLiked(String username) {
        return imageRepository.findImagesByLiked(likedRepository.findLikedByClient(clientRepository.findClientByUsername(username)));

    }




}
