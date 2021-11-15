package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.Advertisement;
import put.poznan.AcoPlaceBackend.model.WebUser;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
