package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.Favourite;

import java.util.List;


public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

    @org.springframework.data.jpa.repository.Query(value="SELECT f.announcement_id FROM Favourite f WHERE f.web_user_id=?1", nativeQuery = true) // dodac active
    List<Integer> getAllAnnouncementIdForCurrentUser(Integer id);
}
