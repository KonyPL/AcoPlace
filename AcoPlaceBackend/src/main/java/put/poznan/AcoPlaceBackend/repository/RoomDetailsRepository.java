package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import put.poznan.AcoPlaceBackend.model.RoomDetails;

public interface RoomDetailsRepository extends JpaRepository<RoomDetails, Long> {

    @Query(value="SELECT * FROM room_details WHERE room_details.announcement_id=?1",nativeQuery = true)
     RoomDetails findByAnnouncementId(long id);
}
