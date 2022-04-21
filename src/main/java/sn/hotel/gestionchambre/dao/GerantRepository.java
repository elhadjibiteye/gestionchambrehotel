package sn.hotel.gestionchambre.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.hotel.gestionchambre.domaine.Gerant;

public interface GerantRepository extends JpaRepository<Gerant,String> {
    Gerant findByEmail(String email);
}
