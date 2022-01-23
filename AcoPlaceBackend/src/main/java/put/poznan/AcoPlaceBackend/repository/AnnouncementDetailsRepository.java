package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import put.poznan.AcoPlaceBackend.model.Announcement;
import put.poznan.AcoPlaceBackend.model.AnnouncementDetails;

import java.util.List;
import java.util.Optional;

public interface AnnouncementDetailsRepository extends JpaRepository<AnnouncementDetails, Long> {


    //posprawdzac nazwy tabel itp. moga tutaj poleciec błedy
    @Query(value="SELECT announcement_details.announcement_id FROM announcement_details WHERE shower=?1  AND oven=?2",nativeQuery = true)
    List<Integer> findAllByParams(Boolean shower, Boolean oven);

    @org.springframework.data.jpa.repository.Query(value="SELECT * FROM announcement_details WHERE announcement_details.announcement_id=?1", nativeQuery = true) // dodac active
    Optional<AnnouncementDetails> findAnnouncementById(Integer id);

}
