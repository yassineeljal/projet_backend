package takfayassine.backendprojet.models;

import jakarta.persistence.*;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    private String name;

    @ManyToOne
    private Client client;

}
