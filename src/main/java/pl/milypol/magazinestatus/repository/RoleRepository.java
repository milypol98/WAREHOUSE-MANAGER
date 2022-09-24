package pl.milypol.magazinestatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.milypol.magazinestatus.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
