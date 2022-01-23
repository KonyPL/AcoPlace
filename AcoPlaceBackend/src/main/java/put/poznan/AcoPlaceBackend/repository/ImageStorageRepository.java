package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import put.poznan.AcoPlaceBackend.model.AnnouncementDetails;
import put.poznan.AcoPlaceBackend.model.ImageStorage;

import java.util.List;

@Repository
public interface ImageStorageRepository extends JpaRepository<ImageStorage, Long> {

    @Query(value="SELECT image_storage.b64image FROM image_storage WHERE image_storage.announcement_id=?1",nativeQuery = true)
    List<String> findAllByAnnouncementId(Integer announcement_id);

}
