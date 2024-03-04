package tn.esprit.pidev.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entity.Interview;
import tn.esprit.pidev.entity.Offer;
import tn.esprit.pidev.repository.InterviewRepository;
import tn.esprit.pidev.repository.OfferRepository;
import tn.esprit.pidev.serviceIterface.IInterviewService;
import tn.esprit.pidev.serviceIterface.IOfferService;

import java.util.List;

@Service
@AllArgsConstructor
public class InterviewService implements IInterviewService {

    InterviewRepository interviewRepository;
    @Override
    public Interview addInterview(Interview interview) {
        return interviewRepository.save(interview);
    }
    @Override
    public List<Interview> retriveInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public Interview updateInterview(Interview interview) { return interviewRepository.save(interview);}

    @Override
    public Interview retriveInterview(Long idInterview) { return interviewRepository.findById(idInterview).orElse(null);}

    @Override
    public void removeInterview(Long idInterview) {interviewRepository.deleteById(idInterview);

    }


}

