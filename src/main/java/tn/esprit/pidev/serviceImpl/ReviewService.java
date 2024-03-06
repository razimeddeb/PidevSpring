package tn.esprit.pidev.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entity.Review;
import tn.esprit.pidev.entity.User;
import tn.esprit.pidev.repository.ReviewReposo;
import tn.esprit.pidev.repository.UserRepository;
import tn.esprit.pidev.serviceIterface.IReviewService;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService implements IReviewService {
    ReviewReposo reviewRepository;
    UserRepository userRepository;

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> retriveReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review affcterReviewAUser(Long id_user, Long id_Review) {
        Review review =reviewRepository.findById(id_Review).orElse(null);
        User user=userRepository.findById(id_user).orElse(null);
        user.getReviews().add(review);
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review retriveReview(Long idReview) {
        return reviewRepository.findById(idReview).orElse(null);
    }

    @Override
    public void removeReview(Long idReview) {
        reviewRepository.deleteById(idReview);

    }
}
