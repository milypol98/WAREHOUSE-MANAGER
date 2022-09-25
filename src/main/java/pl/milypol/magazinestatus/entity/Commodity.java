package pl.milypol.magazinestatus.entity;

import lombok.Data;
import pl.milypol.magazinestatus.enums.TypeCommodity;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TypeCommodity type;
    private Long price;
    private Date Registry;
    @ManyToOne
    private IncomingOrder incomingOrder;

}
