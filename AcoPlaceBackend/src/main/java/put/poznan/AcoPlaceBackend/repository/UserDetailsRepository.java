package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

   // @org.springframework.data.jpa.repository.Query(value="SELECT * FROM user_details u WHERE u.web_user_id =?1", nativeQuery = true)
    UserDetails findByWebUserId(Integer id);
}
