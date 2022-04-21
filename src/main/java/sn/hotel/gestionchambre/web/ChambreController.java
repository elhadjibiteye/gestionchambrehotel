package sn.hotel.gestionchambre.web;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sn.hotel.gestionchambre.dao.ChambreRepository;
import sn.hotel.gestionchambre.domaine.Chambre;

import java.util.List;

@Controller
@AllArgsConstructor
public class ChambreController {
    private ChambreRepository chambreRepository;

    @GetMapping(path = "/admin")
    public String gesChambre(Model model,
                             @RequestParam(name = "page",defaultValue = "0") int page,
                             @RequestParam(name = "size",defaultValue = "3") int size,
                             @RequestParam(name = "motcle",defaultValue = "") String motcle
    ){
        Page<Chambre> pageChambres=chambreRepository.findByNumeroContaining(motcle, PageRequest.of(page,size));
        model.addAttribute("listeChambres",pageChambres.getContent());
        model.addAttribute("pages",new int[pageChambres.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("motcle",motcle);
        return "tbchambre";
    }
    @GetMapping(path = "/acceuil")
    public String home(){
        return "acceuil";
    }


}
