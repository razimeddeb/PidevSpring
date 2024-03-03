package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.entity.CallForTender;
@Repository
public interface CallForTenderRepository extends JpaRepository<CallForTender,Long> {
}
