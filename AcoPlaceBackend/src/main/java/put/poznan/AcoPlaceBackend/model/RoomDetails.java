package put.poznan.AcoPlaceBackend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Announcement announcement;

}
