package sn.hotel.gestionchambre.metier;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sn.hotel.gestionchambre.dao.GerantRepository;
import sn.hotel.gestionchambre.dao.RoleRepository;
import sn.hotel.gestionchambre.domaine.Gerant;
import sn.hotel.gestionchambre.domaine.Role;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class GerantMetierImpl implements GerantMetier{

    private GerantRepository gerantRepository;
    private RoleRepository roleRepository;

    @Override
    public Gerant addNewGerant(Gerant gerant) {
        gerant.setGerantId(UUID.randomUUID().toString());

        return gerantRepository.save(gerant);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Gerant findGerantByEmail(String email) {

        return gerantRepository.findByEmail(email);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToGerant(String email, String roleName) {
        Gerant gerant=this.findGerantByEmail(email);
        Role role=this.findRoleByRoleName(roleName);
        if(gerant.getRoles()!=null){
            gerant.getRoles().add(role);
            role.getGerants().add(gerant);
        }

       // gerantRepository.save(gerant);
    }

    @Override
    public Gerant authentificate(String email, String password) {
        Gerant gerant=gerantRepository.findByEmail(email);
        if(gerant==null) throw  new RuntimeException("Email ou Mot de passe Incorrect !");
        if(gerant.getPassword().equals(password)){
            return gerant;
        }
         throw new RuntimeException("Email ou Mot de passe Incoreect !");
    }

}
