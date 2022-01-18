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
    private String pets; //TODO ENUM acceptance
    private String parties; //TODO ENUM acceptance
    private String quietRoommates; //TODO ENUM acceptance
    private String cookingTogether; //TODO ENUM acceptance
    private String gettingUpInTheMorning; //TODO ENUM acceptance
    private String goingToBedLate; //TODO ENUM acceptance

    @ManyToOne
    private WebUser webUser;

}
