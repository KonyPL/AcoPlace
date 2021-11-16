package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.AnnouncementDetails;

public interface AnnouncementDetailsRepository extends JpaRepository<AnnouncementDetails, Long> {
}
