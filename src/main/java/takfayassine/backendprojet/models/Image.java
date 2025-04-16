package takfayassine.backendprojet.models;

import jakarta.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private String url;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Liked getLiked() {
        return liked;
    }

    public void setLiked(Liked liked) {
        this.liked = liked;
    }

    @ManyToOne
    private Album album;

    @ManyToOne
    private Liked liked;


}
