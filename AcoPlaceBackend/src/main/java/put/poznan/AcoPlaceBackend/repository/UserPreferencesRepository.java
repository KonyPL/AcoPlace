package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.AdvertisementDetails;
import put.poznan.AcoPlaceBackend.model.UserPreferences;

public interface UserPreferencesRepository extends JpaRepository<UserPreferences, Long> {
}
