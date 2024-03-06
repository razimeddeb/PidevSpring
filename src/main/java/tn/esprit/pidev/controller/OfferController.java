package tn.esprit.pidev.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.entity.Offer;
import tn.esprit.pidev.entity.Pack;
import tn.esprit.pidev.serviceIterface.IOfferService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("offer")
public class OfferController {
    IOfferService iOfferService;

    @PostMapping("/addOffre/{id}")
    @ResponseBody
    public ResponseEntity<Long> addOffer(
            @PathVariable("id") Long idOffer,
            @RequestBody Offer offer) {
        Offer response = iOfferService.addOffer(idOffer, offer);
        return ResponseEntity.ok(response.getIdOffer());
    }

    @PostMapping("/addAffectOffer/{userId}")
    public Offer AddAffectOffer(@PathVariable("userId") Long userId,@RequestBody Offer o) {return iOfferService.AddAffectOffer(userId,o);}

    @GetMapping("/getAllOffer")
    public List<Offer> retriveOffers() {return iOfferService.retriveOffers();}
    @PutMapping("/UpdateOffer")
    public Offer updateOffer(@RequestBody Offer offer) {return iOfferService.updateOffer(offer);}
    @GetMapping("/retriveOffer/{id_Offer}")
    public Offer retriveOffer(@PathVariable("id_Offer") Long idOffer) {return iOfferService.retriveOffer(idOffer);}
    @DeleteMapping("/removeOffer/{id_Offer}")
    public void removeOffer(@PathVariable("id_Offer") Long idOffer) {iOfferService.removeOffer(idOffer);}

   @GetMapping("/retrieveOfferByDomain/{domain}")
    @ResponseBody
    public List<Offer> getOfferByDomain(@PathVariable("domain") String domain){
        return iOfferService.getOfferByDomain(domain);
    }

}
