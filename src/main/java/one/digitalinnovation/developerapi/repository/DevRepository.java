package one.digitalinnovation.developerapi.repository;

import one.digitalinnovation.developerapi.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevRepository extends JpaRepository<Developer, Long> {
}
