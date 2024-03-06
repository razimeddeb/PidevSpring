package tn.esprit.pidev.serviceIterface;


import tn.esprit.pidev.entity.CallForTender;

import java.util.List;

public interface ICallForTenderService {
    CallForTender addCallForTender(CallForTender callForTender);
    List<CallForTender> retriveAllCallForTender();
    CallForTender updateCallForTender(CallForTender callForTender);
    List<CallForTender> retriveCallForTender(Long idc);
    void removeCallForTender(Long idc);
    List<CallForTender> searchCallForTenders(String keyword);
}
