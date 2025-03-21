package takfayassine.backendprojet.models;

import jakarta.persistence.*;

@Entity
public class Liked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likedId;

    @OneToOne
    private Client client;
}
