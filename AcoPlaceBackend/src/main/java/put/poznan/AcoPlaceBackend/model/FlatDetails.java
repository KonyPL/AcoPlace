package put.poznan.AcoPlaceBackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class FlatDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean basement;
    private Integer floor;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer flatParking;
    private Integer balcony;

    @ManyToOne
    private Announcement announcement;

}
