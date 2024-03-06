package tn.esprit.pidev.serviceIterface;

import tn.esprit.pidev.entity.Review;

import java.util.List;

public interface IReviewService {

    Review addReview(Review review);
    List<Review> retriveReviews();

    Review updateReview(Review review);
    Review affcterReviewAUser(Long id_user, Long id_Review);

    Review retriveReview(Long idReview);
    void  removeReview (Long idReview);
}
