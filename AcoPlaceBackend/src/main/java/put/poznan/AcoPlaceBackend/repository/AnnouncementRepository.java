package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import put.poznan.AcoPlaceBackend.model.Announcement;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long>, JpaSpecificationExecutor<Announcement> {
    List<Announcement> findAll(@Nullable Specification<Announcement> spec);
}
