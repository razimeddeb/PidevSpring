package tn.esprit.pidev.serviceIterface;

import tn.esprit.pidev.entity.Interview;
import tn.esprit.pidev.entity.Offer;

import java.util.List;

public interface IInterviewService {
    Interview addInterview(Interview interview);
    List<Interview> retriveInterviews();
    Interview updateInterview(Interview interview);
    Interview retriveInterview(Long idInterview);
    void  removeInterview (Long idInterview);
}
