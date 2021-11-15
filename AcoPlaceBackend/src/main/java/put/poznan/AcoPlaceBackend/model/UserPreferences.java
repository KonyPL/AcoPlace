package put.poznan.AcoPlaceBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pets; //TODO ENUM acceptance
    private String parties; //TODO ENUM acceptance
    private String quietRoommates; //TODO ENUM acceptance
    private String cookingTogether; //TODO ENUM acceptance
    private String gettingUpInTheMorning; //TODO ENUM acceptance
    private String goingToBedLate; //TODO ENUM acceptance

    public UserPreferences() {
    }


}
