package tn.esprit.pidev.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entity.Offer;
import tn.esprit.pidev.entity.Pack;
import tn.esprit.pidev.entity.User;
import tn.esprit.pidev.repository.OfferRepository;
import tn.esprit.pidev.repository.UserRepository;
import tn.esprit.pidev.serviceIterface.IOfferService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OfferService implements IOfferService {

    OfferRepository offerRepository;

    UserRepository uRepo;

    @Override
    public Offer addOffer(long id, Offer offer) {
        offerRepository.save(offer);
        User company = uRepo.findById(id).orElse(null);
        offer.getUsers().add(company);
        company.getOffers().add(offer);
        uRepo.save(company);
        return offerRepository.save(offer);
    }

    @Override
    public List<Offer> retriveOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer updateOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer retriveOffer(Long idOffer) {
        return offerRepository.findById(idOffer).orElse(null);
    }

    @Override
    public void removeOffer(Long idOffer) {
        offerRepository.deleteById(idOffer);

    }

    @Override
    public Offer AddAffectOffer(Long userId, Offer o) {
        offerRepository.save(o);
        Optional<User> userCompany = uRepo.findById(userId);
        if (userCompany.isPresent()) {
            User u = userCompany.get();
            u.getOffers().add(o);
            uRepo.save(u);
            List<User> users = new ArrayList<>();
            o.setUsers(users);
            offerRepository.save(o);

        } else {

        }
        return offerRepository.save(o);
    }

    @Override
    public List<Offer> getOfferByDomain(String domain) {
        return offerRepository.findByDomainContainingIgnoreCase(domain);
    }
}
