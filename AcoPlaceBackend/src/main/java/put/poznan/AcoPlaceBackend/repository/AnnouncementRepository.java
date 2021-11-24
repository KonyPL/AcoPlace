package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import put.poznan.AcoPlaceBackend.model.Announcement;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    //posprawdzac nazwy tabel itp. moga tutaj poleciec błedy
    @Query(value="SELECT announcement.id FROM announcement WHERE announcement.price BETWEEN ?1 AND ?2 AND announcement.property_type=?3",nativeQuery = true)
    List<Integer> findAllByParams(Integer priceMin, Integer priceMax, String propertyType);
}
