package sn.hotel.gestionchambre.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.hotel.gestionchambre.domaine.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    Chambre findByNumero(String numero);
    Page<Chambre> findByNumeroContaining(String numero, Pageable pageable);
}
