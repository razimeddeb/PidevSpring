package tn.esprit.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.entity.Pack;
@Repository
public interface PackRepository extends JpaRepository<Pack,Long> {
}
