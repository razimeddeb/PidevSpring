package tn.esprit.pidev.serviceIterface;

import tn.esprit.pidev.entity.Pack;

import java.util.List;

public interface IPackService {
    Pack addPack(Pack pack);
    List<Pack> retriveAllPacks();
    Pack updatePack(Pack pack);
    Pack retrivePack(Long idPack);
    void  removePack (Long idPack);
    //public  Pack affcterPackACompany(Long id_user,Long id_Pack);
}
