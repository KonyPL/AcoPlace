package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
