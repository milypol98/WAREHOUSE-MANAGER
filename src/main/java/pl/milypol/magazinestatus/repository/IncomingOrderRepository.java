package pl.milypol.magazinestatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.milypol.magazinestatus.entity.IncomingOrder;

public interface IncomingOrderRepository extends JpaRepository<IncomingOrder,Long> {
}
