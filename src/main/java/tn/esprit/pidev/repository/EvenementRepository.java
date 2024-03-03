package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.entity.Evenement;
@Repository
public interface EvenementRepository extends JpaRepository<Evenement,Long> {
}
