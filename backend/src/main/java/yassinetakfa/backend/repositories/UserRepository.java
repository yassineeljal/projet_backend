package yassinetakfa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yassinetakfa.backend.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findUserByEmailAndPassword(String email, String password);
}
