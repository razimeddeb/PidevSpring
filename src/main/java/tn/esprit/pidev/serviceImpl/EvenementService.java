package tn.esprit.pidev.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entity.Evenement;
import tn.esprit.pidev.repository.EvenementRepository;
import tn.esprit.pidev.serviceIterface.IEvenementService;

import java.util.List;

@Service
@AllArgsConstructor
public class EvenementService implements IEvenementService {
    EvenementRepository evenementRepository;
    @Override
    public Evenement addEvenement(Evenement event) {
        return evenementRepository.save(event);
    }

    @Override
    public List<Evenement> retriveEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement updateEvenement(Evenement event) {
        return evenementRepository.save(event);
    }

    @Override
    public Evenement retriveEvenement(Long idEvenement) {
        return evenementRepository.findById(idEvenement).orElse(null);
    }

    @Override
    public void removeEvenement(Long idEvenemnt) {
        evenementRepository.deleteById(idEvenemnt);

    }
}
