package put.poznan.AcoPlaceBackend.repository.OLD;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.OLD.WebUser;

public interface UserRepository extends JpaRepository<WebUser, Long> {
}
