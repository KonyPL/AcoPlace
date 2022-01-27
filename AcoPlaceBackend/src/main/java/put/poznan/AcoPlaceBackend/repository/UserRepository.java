package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import put.poznan.AcoPlaceBackend.model.WebUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<WebUser, Long> {

    @Query(value="SELECT * FROM web_user WHERE web_user.user_name=?1",nativeQuery = true)
    Optional<WebUser> findByUserName(String userName);
}
