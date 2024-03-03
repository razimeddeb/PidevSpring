package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.entity.Booth;
@Repository
public interface BoothRepository extends JpaRepository<Booth,Long> {
}
