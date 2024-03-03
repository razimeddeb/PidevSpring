package tn.esprit.pidev.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.entity.Booth;
import tn.esprit.pidev.serviceIterface.IBoothService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("booth")
public class BoothController {
    IBoothService iBoothService;
    @PostMapping("/addBooth")
    public Booth addBooth(@RequestBody Booth booth) {
        return iBoothService.addBooth(booth);
    }
    @GetMapping("/getAllBooths")
    public List<Booth> retriveAllBooths() {
        return iBoothService.retriveAllBooths();
    }
    @PutMapping("/UpdateBooth")
    public Booth updateBooth(@RequestBody Booth booth) {
        return iBoothService.updateBooth(booth);
    }
    @GetMapping("/retriveBooth/{id_Booth}")
    public Booth retriveBooth(@PathVariable("id_Booth") Long idBooth) {
        return iBoothService.retriveBooth(idBooth);
    }
    @DeleteMapping("/removeBooth/{id_Booth}")
    public void removeBooth(@PathVariable("id_Booth") Long idBooth) {
        iBoothService.removeBooth(idBooth);
    }


}
