package pl.milypol.magazinestatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.milypol.magazinestatus.entity.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity,Long> {
}
