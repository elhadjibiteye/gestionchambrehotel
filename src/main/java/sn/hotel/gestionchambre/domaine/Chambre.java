package sn.hotel.gestionchambre.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Chambre {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String numero;
    private String categorie;
    private double prix;
    private boolean disponibilite;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Client> clients;
    @ManyToOne
    private Gerant gerant;
}
