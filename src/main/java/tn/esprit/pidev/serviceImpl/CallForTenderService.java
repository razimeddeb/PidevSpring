package tn.esprit.pidev.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.PDF.PdfGenerator;
import tn.esprit.pidev.entity.CallForTender;
import tn.esprit.pidev.repository.CallForTenderRepository;
import tn.esprit.pidev.serviceIterface.ICallForTenderService;

import java.util.Collections;
import java.util.List;
@Service
public class CallForTenderService implements ICallForTenderService {

    @Autowired
    CallForTenderRepository callForTenderRepository;
    private PdfGenerator pdfGenerator;
    @Override
    public CallForTender addCallForTender(CallForTender callForTender) {
        return callForTenderRepository.save(callForTender);
    }

    @Override
    public List<CallForTender> retriveAllCallForTender() {
        return callForTenderRepository.findAll();
    }

    @Override
    public CallForTender updateCallForTender(CallForTender callForTender) {
        System.out.println("call"+callForTender);
        return callForTenderRepository.save(callForTender);
    }

    @Override
    public List<CallForTender> retriveCallForTender(Long idc) {
        return callForTenderRepository.findAllById(Collections.singleton(idc));
    }

    @Override
    public void removeCallForTender(Long idc) {
        callForTenderRepository.deleteById(idc);



    }
    @Override
    public List<CallForTender> searchCallForTenders(String keyword) {


        List<CallForTender> searchResults = new ArrayList<>();


        return searchResults;
    }

    }

