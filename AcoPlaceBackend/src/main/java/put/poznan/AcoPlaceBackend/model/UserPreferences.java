package put.poznan.AcoPlaceBackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pets;
    private String parties;
    private String quietRoommates;
    private String cookingTogether;
    private String gettingUpInTheMorning;
    private String goingToBedLate;

    @ManyToOne
    private WebUser webUser;

}
