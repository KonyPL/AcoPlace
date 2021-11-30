package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import put.poznan.AcoPlaceBackend.model.HouseDetails;

public interface HouseDetailsRepository extends JpaRepository<HouseDetails, Long> {

    @Query(value="SELECT * FROM house_details WHERE house_details.announcement_id=?1",nativeQuery = true)
    HouseDetails findByAnnouncementId(long id);
}
