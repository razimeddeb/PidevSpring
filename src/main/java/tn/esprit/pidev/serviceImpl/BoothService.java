package tn.esprit.pidev.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.dto.BoothDto;
import tn.esprit.pidev.entity.Booth;
import tn.esprit.pidev.entity.Pack;
import tn.esprit.pidev.entity.StatusBooth;
import tn.esprit.pidev.repository.BoothRepository;
import tn.esprit.pidev.repository.PackRepository;
import tn.esprit.pidev.serviceIterface.IBoothService;

import java.util.List;

@Service
@AllArgsConstructor
public class BoothService implements IBoothService {
    BoothRepository boothRepository;
    PackRepository  packRepository;
    @Override
    public Booth addBooth(Booth booth) {
        return boothRepository.save(booth);
    }

    @Override
    public List<Booth> retriveAllBooths() {
        return boothRepository.findAll();
    }

    @Override
    public Booth updateBooth(Booth booth) {
        return boothRepository.save(booth);
    }

    @Override
    public Booth retriveBooth(Long idBooth) {
        return boothRepository.findById(idBooth).orElse(null);
    }

    @Override
    public void removeBooth(Long idBooth) {
        boothRepository.deleteById(idBooth);

    }

    @Override
    public Booth ajouterBoothEtAffecterAPack(BoothDto boothDto, Long idPack) {
        Pack pack=packRepository.findById(idPack).orElse(null);
        Booth booth =new Booth();
        booth.setStatusBooth(StatusBooth.AVAILABLE);
        booth.setDescription(boothDto.getDescription());
        booth.setPack(pack);
        return boothRepository.save(booth);
    }

    @Override
    public List<Booth> afficherListBoothWithPackId(Long idPack) {

        return boothRepository.findBoothByPackIdPack(idPack);
    }


}
