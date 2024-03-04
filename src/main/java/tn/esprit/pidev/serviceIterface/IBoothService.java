package tn.esprit.pidev.serviceIterface;

import tn.esprit.pidev.dto.BoothDto;
import tn.esprit.pidev.entity.Booth;
import tn.esprit.pidev.entity.Pack;
import tn.esprit.pidev.entity.StatusBooth;

import java.util.List;

public interface IBoothService {
    Booth addBooth(Booth booth);
    List<Booth> retriveAllBooths();
    Booth updateBooth(Booth booth);
    Booth retriveBooth(Long idBooth);
    void removeBooth(Long idBooth);
    public Booth ajouterBoothEtAffecterAPack(BoothDto boothDto, Long idPack);
    public    List<Booth> afficherListBoothWithPackId(Long idPack);

}
