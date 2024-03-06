package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.entity.AffectationRequest;
@Repository
public interface AffectationRequestRepository extends JpaRepository<AffectationRequest , Long> {
}
