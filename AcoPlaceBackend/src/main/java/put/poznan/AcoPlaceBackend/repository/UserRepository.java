package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.WebUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<WebUser, Long> {
    Optional<WebUser> findByEmail(String email);
    Optional<WebUser> findByUsernameOrEmail(String username, String email);
    Optional<WebUser> findByUsername(String username);
    //Boolean existsByUsername(String username);
   // Boolean existsByEmail(String email);

}
