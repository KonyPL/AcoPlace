package  put.poznan.AcoPlace.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import put.poznan.AcoPlace.admin.model.Announcement;


import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    @Query("SELECT  announcement FROM Announcement announcement WHERE announcement.title LIKE :title%")
    @Transactional(readOnly = true)
    List<Announcement> findByTitle(@Param("title") String title);

    @Query("SELECT  announcement FROM Announcement announcement WHERE announcement.reported = 'true' OR announcement.edited = 'true'")
    List<Announcement> findAllReported();

    @Query("SELECT  announcement FROM Announcement announcement WHERE announcement.active = 'false' AND announcement.edited = 'false' AND announcement.reported = 'false'")
    List<Announcement> findAllInactive();

    @Query("SELECT announcement FROM Announcement announcement WHERE announcement.editedByUser = 'true' AND announcement.edited = 'false' AND announcement.reported = 'false' ") // tu chce miec edytowane przez usera ale edited na false oraz raported an true, bo sa swiezo dodane nie zraportowane jeszcze
    List<Announcement> findAllEditedByUser();

    @Query("SELECT announcement FROM Announcement announcement WHERE announcement.editedByUser = 'true' ") // tu chc miec edytowane przez usera oraz zraportowane (raported na true) lub edytowane (edited na true)
    List<Announcement> findAllEditedByUserAndReportedOrEdited();


}
