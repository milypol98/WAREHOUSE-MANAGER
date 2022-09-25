package pl.milypol.magazinestatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.milypol.magazinestatus.entity.IncomingOrder;

import java.util.List;

public interface IncomingOrderRepository extends JpaRepository<IncomingOrder,Long> {
    List <IncomingOrder> findAllByUserId(Long user_id);
}
