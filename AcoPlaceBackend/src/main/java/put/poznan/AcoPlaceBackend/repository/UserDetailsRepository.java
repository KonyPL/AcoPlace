package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    UserDetails findByWebUserId(Integer id);
}
