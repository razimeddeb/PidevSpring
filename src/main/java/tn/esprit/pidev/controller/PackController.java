package tn.esprit.pidev.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.entity.Pack;
import tn.esprit.pidev.serviceIterface.IPackService;

import java.util.List;
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("pack")

public class PackController {
   /* @PutMapping("/affcterPackACompany/{idUser}/{idPack}")
    public Pack affcterPackACompany(@PathVariable("idUser") Long id_user,@PathVariable("idPack") Long id_Pack) {
        return iPackService.affcterPackACompany(id_user, id_Pack);
    }*/

    IPackService iPackService;
    @PostMapping("/addPack")
    public Pack addPack(@RequestBody Pack pack) {
        return iPackService.addPack(pack);
    }
    @GetMapping("/getAllPack")
    public List<Pack> retriveAllPacks() {
        return iPackService.retriveAllPacks();
    }
    @PutMapping("/UpdatePack")
    public Pack updatePack(@RequestBody Pack pack) {
        return iPackService.updatePack(pack);
    }
    @GetMapping("/retrivePack/{id_Pack}")
    public Pack retrivePack(@PathVariable("id_Pack") Long idPack) {
        return iPackService.retrivePack(idPack);
    }
    @DeleteMapping("/removePack/{id_Pack}")
    public void removePack(@PathVariable("id_Pack") Long idPack) {
        iPackService.removePack(idPack);
    }






}
