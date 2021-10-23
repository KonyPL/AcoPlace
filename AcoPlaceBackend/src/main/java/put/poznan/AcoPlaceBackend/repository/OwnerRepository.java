package put.poznan.AcoPlaceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import put.poznan.AcoPlaceBackend.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
