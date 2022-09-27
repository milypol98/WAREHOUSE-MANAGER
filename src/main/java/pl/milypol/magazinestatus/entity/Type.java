package pl.milypol.magazinestatus.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @ManyToOne
    private User user;

}
