package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.entity.Review;
@Repository
public interface ReviewReposo extends JpaRepository<Review,Long> {
}
