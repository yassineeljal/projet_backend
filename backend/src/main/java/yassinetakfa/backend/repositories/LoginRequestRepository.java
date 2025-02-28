package yassinetakfa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yassinetakfa.backend.models.LoginRequest;

public interface LoginRequestRepository extends JpaRepository<LoginRequest,Long> {
}
