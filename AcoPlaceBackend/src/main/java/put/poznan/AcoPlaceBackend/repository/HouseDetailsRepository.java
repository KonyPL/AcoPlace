package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.HouseDetails;

public interface HouseDetailsRepository extends JpaRepository<HouseDetails, Long> {
}
