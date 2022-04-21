package sn.hotel.gestionchambre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import sn.hotel.gestionchambre.domaine.Chambre;
import sn.hotel.gestionchambre.domaine.Civilite;
import sn.hotel.gestionchambre.domaine.Gerant;
import sn.hotel.gestionchambre.domaine.Role;
import sn.hotel.gestionchambre.metier.ChambreMetier;
import sn.hotel.gestionchambre.metier.GerantMetier;

import java.util.stream.Stream;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})

public class GestionChambreApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionChambreApplication.class, args);
    }
    @Bean
        CommandLineRunner start(GerantMetier gerantMetier, ChambreMetier chambreMetier){
            return args -> {
                //Ajout Gerant
                Gerant gerant1=new Gerant();
                gerant1.setNom("BITEYE");
                gerant1.setPrenom("Elhadji");
                gerant1.setCivilite(Civilite.Mr);
                gerant1.setEmail("elhadji@gmail.com");
                gerant1.setPassword("passer123");
                gerantMetier.addNewGerant(gerant1);

                Gerant gerant2=new Gerant();
                gerant2.setNom("THIAM");
                gerant2.setPrenom("Koffi");
                gerant2.setCivilite(Civilite.Mr);
                gerant2.setEmail("koffi@gmail.com");
                gerant2.setPassword("passer12");
                gerantMetier.addNewGerant(gerant2);

                Gerant gerant3=new Gerant();
                gerant3.setNom("SAKHO");
                gerant3.setPrenom("Khalil");
                gerant3.setCivilite(Civilite.Mr);
                gerant3.setEmail("khalil@gmail.com");
                gerant3.setPassword("passer");
                gerantMetier.addNewGerant(gerant3);
                //Ajout Role
                Stream.of("proprietaire","agent").forEach(r->{
                    Role role1=new Role();
                    role1.setRoleName(r);
                    gerantMetier.addNewRole(role1);
                });
                //Asignation Role à un Gerant
              gerantMetier.addRoleToGerant("elhadji@gmail.com","proprietaire");
              gerantMetier.addRoleToGerant("koffi@gmail.com","agent");
              gerantMetier.addRoleToGerant("khalil@gmail.com","agent");


                //Ajout Chambre
                Chambre chambre1=new Chambre();
                chambre1.setNumero("CH001");
                chambre1.setCategorie("5 etoiles");
                chambre1.setPrix(80000);
                chambre1.setDisponibilite(true);
                chambre1.setGerant(gerant1);
                chambreMetier.addNewChambre(chambre1);

                Chambre chambre2=new Chambre();
                chambre2.setNumero("CH002");
                chambre2.setCategorie("3 etoiles");
                chambre2.setPrix(50000);
                chambre2.setDisponibilite(false);
                chambre2.setGerant(gerant2);
                chambreMetier.addNewChambre(chambre2);

                Chambre chambre3=new Chambre();
                chambre3.setNumero("CH003");
                chambre3.setCategorie("3 etoiles");
                chambre3.setPrix(40000);
                chambre3.setDisponibilite(false);
                chambre3.setGerant(gerant3);
                chambreMetier.addNewChambre(chambre3);

                Chambre chambre4=new Chambre();
                chambre4.setNumero("CH008");
                chambre4.setCategorie("5 etoiles");
                chambre4.setPrix(100000);
                chambre4.setDisponibilite(true);
                chambre4.setGerant(gerant1);
                chambreMetier.addNewChambre(chambre4);

                Chambre chambre5=new Chambre();
                chambre5.setNumero("CH0011");
                chambre5.setCategorie("2 etoiles");
                chambre5.setPrix(15000);
                chambre5.setDisponibilite(true);
                chambre5.setGerant(gerant2);
                chambreMetier.addNewChambre(chambre5);
            };
        }
}
