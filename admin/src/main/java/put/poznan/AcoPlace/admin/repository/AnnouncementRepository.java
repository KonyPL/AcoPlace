package  put.poznan.AcoPlace.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import put.poznan.AcoPlace.admin.model.Announcement;


import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

}
