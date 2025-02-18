package isis.projet.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_utilisateur;

    @NotBlank
    @NotEmpty
    @NonNull
    private String pseudo;

    @NotBlank
    @NotEmpty
    @NonNull
    private String email;

    @NotBlank
    @NotEmpty
    @NonNull
    private String mdp;

    @ElementCollection
    private List<String> preferences; // Liste de préférences de l'utilisateur

    @OneToMany(mappedBy = "utilisateur")
    private List<Session> sessions; // Un utilisateur a plusieurs sessions

    public Utilisateur(String pseudo, String email, String mdp, List<String> preferences) {
        this.pseudo = pseudo;
        this.email = email;
        this.mdp = mdp;
        this.preferences = preferences;
    }

    public void enregistrerSession(Session newsession){
        this.sessions.add(newsession);
    }

}
