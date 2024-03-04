package tn.esprit.pidev.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.entity.Interview;
import tn.esprit.pidev.entity.Offer;
import tn.esprit.pidev.serviceIterface.IInterviewService;
import tn.esprit.pidev.serviceIterface.IOfferService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("interview")
public class InterviewController {
    IInterviewService iInterviewService;
    @PostMapping("/addInterview")
    public Interview addInterview(@RequestBody Interview interview) {return iInterviewService.addInterview(interview);}

    @GetMapping("/getAllInterview")
    public List<Interview> retriveInterviews() {return iInterviewService.retriveInterviews();}
    @PutMapping("/UpdateInterview")
    public Interview updateInterview(@RequestBody Interview interview) {return iInterviewService.updateInterview(interview);}
    @GetMapping("/retriveInterview/{id_Interview}")
    public Interview retriveInterview(@PathVariable("id_Interview") Long idInterview) {return iInterviewService.retriveInterview(idInterview);}
    @DeleteMapping("/removeInterview/{id_Interview}")
    public void removeInterview(@PathVariable("id_Interview") Long idInterview) {iInterviewService.removeInterview(idInterview);}


}
