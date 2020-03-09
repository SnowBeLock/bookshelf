package lv.itlat.bookshelf.percistence.domain;

import javax.persistence.*;

@Entity(name = "Reservation")
@Table(name="RESERVATION")
public class Reservation {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
}
