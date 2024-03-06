package tn.esprit.pidev.serviceIterface;

import tn.esprit.pidev.entity.Evenement;

import java.util.List;

public interface IEvenementService {

    Evenement addEvenement(Evenement event);
    List<Evenement> retriveEvenements();

    Evenement updateEvenement(Evenement event);
    Evenement retriveEvenement(Long idEvenement);
    void  removeEvenement (Long idEvenement);
}
