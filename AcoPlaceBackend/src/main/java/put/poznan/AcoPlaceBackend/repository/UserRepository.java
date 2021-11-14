package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.WebUser;

public interface UserRepository extends JpaRepository<WebUser, Long> {
}
