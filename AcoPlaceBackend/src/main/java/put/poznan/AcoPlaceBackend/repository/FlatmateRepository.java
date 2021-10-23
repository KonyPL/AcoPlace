package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.Flatmate;

public interface FlatmateRepository extends JpaRepository<Flatmate, Long> {
}
