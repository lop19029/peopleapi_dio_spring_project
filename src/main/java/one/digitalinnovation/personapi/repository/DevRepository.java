package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevRepository extends JpaRepository<Developer, Long> {
}
