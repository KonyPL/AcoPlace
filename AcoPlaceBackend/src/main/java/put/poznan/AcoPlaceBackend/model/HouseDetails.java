package put.poznan.AcoPlaceBackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class HouseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer floors;
    private Boolean basement;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer lotSize;
    private Boolean parking;
    private Integer balcony;

    @ManyToOne
    private Announcement announcement;

}
