package pl.milypol.magazinestatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.milypol.magazinestatus.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String Username);
}
