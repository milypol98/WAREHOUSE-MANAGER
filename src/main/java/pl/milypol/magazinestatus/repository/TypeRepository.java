package pl.milypol.magazinestatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.milypol.magazinestatus.entity.Type;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type , Long> {
    List <Type> findAllByUserId(Long userId);
}
