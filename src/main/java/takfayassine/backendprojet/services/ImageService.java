package takfayassine.backendprojet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takfayassine.backendprojet.repositories.AlbumRepository;
import takfayassine.backendprojet.repositories.ClientRepository;
import takfayassine.backendprojet.repositories.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ImageRepository imageRepository;



}
