package pl.milypol.magazinestatus.entity;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Type type;
    private Long price;
    private Long Registry;
    @ManyToOne
    private IncomingOrder incomingOrder;

}
