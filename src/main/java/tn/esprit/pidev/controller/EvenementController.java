package tn.esprit.pidev.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.entity.Evenement;
import tn.esprit.pidev.serviceIterface.IEvenementService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("Evenement")
public class EvenementController {
        IEvenementService iEvenementService;
        @PostMapping("/addEvenement")

        public Evenement addEvenement(@RequestBody Evenement event) {
            return iEvenementService.addEvenement(event);
        }
        @GetMapping("/getAllEvenement")
        public List<Evenement> retriveEvenemnt() {
            return iEvenementService.retriveEvenements();
        }
        @PutMapping("/UpdateEvenement")
        public Evenement updateEvenement(@RequestBody Evenement event) {
            return iEvenementService.updateEvenement(event);
        }
        @GetMapping("/retriveEvenement/{id_Evenement}")
        public Evenement retriveEvenement(@PathVariable("id_Evenement") Long idEvenement) {
            return iEvenementService.retriveEvenement(idEvenement);
        }
        @DeleteMapping("/removeEvenement/{id_Evenement}")
        public void removeEvenement(@PathVariable("id_Evenement") Long idEvenement) {
            iEvenementService.removeEvenement(idEvenement);
        }
}
