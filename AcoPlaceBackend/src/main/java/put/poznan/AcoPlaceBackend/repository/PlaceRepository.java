package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
