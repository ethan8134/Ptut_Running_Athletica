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

public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categorie;

    @NotBlank
    @NotEmpty
    @NonNull
    private String nom_categorie;

    @OneToMany(mappedBy = "categorie")
    private List<Indicateur> indicateurs; // Une catégorie regroupe plusieurs indicateurs

    public Categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }
}
