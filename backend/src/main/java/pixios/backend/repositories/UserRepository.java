package pixios.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pixios.backend.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
