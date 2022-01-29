package put.poznan.AcoPlaceBackend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Announcement announcement;

}
