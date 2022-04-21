package sn.hotel.gestionchambre.metier;

import sn.hotel.gestionchambre.domaine.Chambre;

public interface ChambreMetier {
    Chambre addNewChambre(Chambre chambre);
    Chambre findChambreByNumero(String numero);

   // void addRoleToGerant(String email,String roleName);

}
