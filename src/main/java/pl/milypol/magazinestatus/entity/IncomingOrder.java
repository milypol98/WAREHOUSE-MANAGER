package pl.milypol.magazinestatus.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class IncomingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Long price;
    private Long weighs;
    //Zmienic na date + literowka
    private Long Came;
    private String producer;
    @OneToMany
    private List<Commodity> commodity;
}
