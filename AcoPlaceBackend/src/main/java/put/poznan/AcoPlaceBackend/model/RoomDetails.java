package put.poznan.AcoPlaceBackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class RoomDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer floor;
    private Integer bedsInRoom;
    private Integer numberOfFlatmates;
    private Integer bathrooms;

    @ManyToOne
    private Announcement announcement;

}
