package tn.esprit.pidev.serviceIterface;

import tn.esprit.pidev.entity.Offer;
import tn.esprit.pidev.entity.Pack;

import java.util.List;

public interface IOfferService {
    Offer addOffer(long id , Offer offer);
    List<Offer> retriveOffers();
    Offer updateOffer(Offer offer);
    Offer retriveOffer(Long idOffer);
    void  removeOffer (Long idOffer);

    public Offer AddAffectOffer(Long userId, Offer o);

public List<Offer> getOfferByDomain(String domain);
}
