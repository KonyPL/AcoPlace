package put.poznan.AcoPlace.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlace.admin.model.WebUser;


import java.util.Optional;

public interface UserRepository extends JpaRepository<WebUser, Long> {
    Optional<WebUser> findByUserName(String userName);

}
