package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.RoomDetails;

public interface RoomDetailsRepository extends JpaRepository<RoomDetails, Long> {
}
