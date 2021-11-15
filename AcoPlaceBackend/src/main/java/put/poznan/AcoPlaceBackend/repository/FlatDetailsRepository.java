package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.FlatDetails;

public interface FlatDetailsRepository extends JpaRepository<FlatDetails, Long> {
}
