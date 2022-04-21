package sn.hotel.gestionchambre.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GERANTS")
@Data @NoArgsConstructor @AllArgsConstructor
public class Gerant{
    @Id
    private String gerantId;
    private String nom;
    private String prenom;
    private Civilite civilite;
    @Column(unique = true,length = 30)
    private String email;
    private String password;
    @ManyToMany(mappedBy = "gerants",fetch = FetchType.EAGER)
    private List<Role> roles=new ArrayList<>();
    @OneToMany(mappedBy = "gerant",fetch = FetchType.LAZY)
    private List<Chambre> chambres;

}
