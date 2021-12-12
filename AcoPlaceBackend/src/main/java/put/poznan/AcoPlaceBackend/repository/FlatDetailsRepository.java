package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import put.poznan.AcoPlaceBackend.model.FlatDetails;

public interface FlatDetailsRepository extends JpaRepository<FlatDetails, Long> {

    @Query(value="SELECT * FROM flat_details WHERE flat_details.announcement_id=?1",nativeQuery = true)
    FlatDetails findByAnnouncementId(long id);
}
