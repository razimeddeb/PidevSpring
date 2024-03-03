package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.entity.Interview;
@Repository
public interface InterviewRepository extends JpaRepository<Interview,Long> {

}
