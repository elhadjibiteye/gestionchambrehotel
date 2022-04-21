package sn.hotel.gestionchambre.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Civilite civilite;
    private String email;
    private String telephone;
    @ManyToMany(mappedBy = "clients",fetch = FetchType.LAZY)
    private List<Chambre> chambres;
}
