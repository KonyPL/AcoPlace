package put.poznan.AcoPlaceBackend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Announcement announcement;

}
