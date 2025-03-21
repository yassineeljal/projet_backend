package takfayassine.backendprojet.models;

import jakarta.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private String url;

    @ManyToOne
    private Album album;

    @ManyToOne
    private Liked liked;


}
