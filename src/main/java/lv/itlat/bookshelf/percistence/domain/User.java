package lv.itlat.bookshelf.percistence.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "User")
@Table(name="USER")
public class User implements Serializable {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
}
