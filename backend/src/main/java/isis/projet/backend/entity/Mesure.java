package isis.projet.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity

public class Mesure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mesure;

    @NotBlank
    @NotEmpty
    @NonNull
    private String valeur;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date_mesure;

    @ManyToOne
    @JoinColumn(name = "indicateur_id")
    private Indicateur indicateur;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    public Mesure(String valeur, Date date_mesure, Indicateur indicateur, Session session) {
        this.valeur = valeur;
        this.date_mesure = date_mesure;
        this.indicateur = indicateur;
        this.session = session;
    }
}
