package tn.esprit.pidev.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entity.Interview;
import tn.esprit.pidev.entity.Offer;
import tn.esprit.pidev.entity.User;
import tn.esprit.pidev.repository.InterviewRepository;
import tn.esprit.pidev.repository.OfferRepository;
import tn.esprit.pidev.repository.UserRepository;
import tn.esprit.pidev.serviceIterface.IInterviewService;
import tn.esprit.pidev.serviceIterface.IOfferService;

import java.util.List;

@Service
@AllArgsConstructor
public class InterviewService implements IInterviewService {

    InterviewRepository interviewRepository;
    OfferRepository offerRepository;
    UserRepository userRepository;
    @Override
    public Interview addInterview (Interview i) {

        Interview interview = interviewRepository.findById(i.getIdInterview()).orElse(null);

        interview.setInterviewer(i.getInterviewer());
        interview.setDateInterview(i.getDateInterview());
        interview.setRequestStatus(2);

        return interviewRepository.save(interview);
    }

    public Interview demanderInterview(long userId, long offerId, Interview interview) {
        //iRepo.save(i);
        Offer offer = offerRepository.findById(offerId).orElse(null);
        User participant = userRepository.findById(userId).orElse(null);
        interview.setOffer(offer);
        interview.getOffer().getUsers().add(participant);
        interview.setRequestStatus(1);
        offerRepository.save(offer);
        userRepository.save(participant);
        return interviewRepository.save(interview);
    }


    @Override
    public List<Interview> retriveInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public Interview updateInterview(Interview interview) {return interviewRepository.save(interview);}

    @Override
    public Interview retriveInterview(Long idInterview) {return interviewRepository.findById(idInterview).orElse(null);}

    @Override
    public void removeInterview(Long idInterview) {interviewRepository.deleteById(idInterview);

    }


}

