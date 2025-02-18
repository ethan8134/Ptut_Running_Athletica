package isis.projet.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity

public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_session;

    @NotBlank
    @NotEmpty
    @NonNull
    private String nomSession;

    @ElementCollection // Permet d'utiliser une liste d'éléments simples
    @CollectionTable(name = "session_fichiers", joinColumns = @JoinColumn(name = "session_id"))
    @Column(name = "fichier")
    private List<String> fichier = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP) // Spécifie le type de date pour JPA
    private Date date_session;

    public Session(String nomSession, Date date_session) {
        this.nomSession = nomSession;
        this.fichier = new ArrayList<>();
        this.date_session = date_session;
    }


}
