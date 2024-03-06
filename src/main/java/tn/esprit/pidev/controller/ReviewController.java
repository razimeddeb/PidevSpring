package tn.esprit.pidev.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.entity.Pack;
import tn.esprit.pidev.entity.Review;
import tn.esprit.pidev.serviceIterface.IReviewService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("Review")
public class ReviewController {

    IReviewService iReviewService;


    @PutMapping("/affcterReviewAUser/{idUser}/{idReview}")
    public Review affcterReviewAUser(@PathVariable("idUser") Long id_user, @PathVariable("idReview") Long id_Review) {
        return iReviewService.affcterReviewAUser(id_user, id_Review);
    }

    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review) {
        return iReviewService.addReview(review);
    }
    @GetMapping("/getAllReview")
    public List<Review> retriveReviews() {
        return iReviewService.retriveReviews();
    }
    @PutMapping("/UpdateReview")
    public Review updateReview(@RequestBody Review event) {
        return iReviewService.updateReview(event);
    }
    @GetMapping("/retriveReview/{id_Review}")
    public Review retriveReview(@PathVariable("id_Review") Long idReview) {
        return iReviewService.retriveReview(idReview);
    }
    @DeleteMapping("/removeReview/{id_Review}")
    public void removeReview(@PathVariable("id_Review") Long idReview) {
        iReviewService.removeReview(idReview);
    }
}
