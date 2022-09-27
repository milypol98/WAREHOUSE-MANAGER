package pl.milypol.magazinestatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.milypol.magazinestatus.entity.Commodity;

import java.util.List;

public interface CommodityRepository extends JpaRepository<Commodity,Long> {
    List<Commodity> findAllByIncomingOrderId(Long incomingOrderId);
}
