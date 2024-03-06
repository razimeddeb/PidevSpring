package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.entity.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {

  List<Offer> findByDomainContainingIgnoreCase(String domain);

}
