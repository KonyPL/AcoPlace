package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.AdvertisementDetails;

public interface AdvertisementDetailsRepository extends JpaRepository<AdvertisementDetails, Long> {
}
