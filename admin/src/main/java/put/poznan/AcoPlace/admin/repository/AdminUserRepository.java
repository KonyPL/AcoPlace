package put.poznan.AcoPlace.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import put.poznan.AcoPlace.admin.model.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
  // @Query("SELECT u FROM admin_user u WHERE u.email = ?1")
    public AdminUser findByEmail(String email);
}
