package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
