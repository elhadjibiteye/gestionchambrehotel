package sn.hotel.gestionchambre.metier;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.hotel.gestionchambre.dao.ChambreRepository;
import sn.hotel.gestionchambre.domaine.Chambre;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ChambreMetierImpl implements ChambreMetier{

   private ChambreRepository chambreRepository;
    @Override
    public Chambre addNewChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre findChambreByNumero(String numero) {
        return chambreRepository.findByNumero(numero);
    }
}
