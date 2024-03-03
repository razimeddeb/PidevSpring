package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.entity.Offer;
@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
}
