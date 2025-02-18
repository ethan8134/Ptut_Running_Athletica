package isis.projet.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity

public class Indicateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_indicateur;

    @NotBlank
    @NotEmpty
    @NonNull
    private String nomIndicateur;

    @NotBlank
    @NotEmpty
    @NonNull
    private String unite;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public Indicateur(String nomIndicateur, String unite, Categorie categorie) {
        this.nomIndicateur = nomIndicateur;
        this.unite = unite;
        this.categorie = categorie;
    }
}
