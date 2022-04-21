package sn.hotel.gestionchambre.metier;

import sn.hotel.gestionchambre.domaine.Gerant;
import sn.hotel.gestionchambre.domaine.Role;

public interface GerantMetier {
    Gerant addNewGerant(Gerant gerant);
    Role addNewRole(Role role);
    Gerant findGerantByEmail(String email);
    Role findRoleByRoleName(String roleName);
    void addRoleToGerant(String email,String roleName);
    Gerant authentificate(String email,String password);
}

