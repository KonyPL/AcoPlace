package put.poznan.AcoPlaceBackend.model;

import javax.persistence.*;

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

    @ManyToOne
    private WebUser webUser;

    public UserPreferences() {
    }

    public UserPreferences(Long id, String pets, String parties, String quietRoommates, String cookingTogether, String gettingUpInTheMorning, String goingToBedLate, WebUser webUser) {
        this.id = id;
        this.pets = pets;
        this.parties = parties;
        this.quietRoommates = quietRoommates;
        this.cookingTogether = cookingTogether;
        this.gettingUpInTheMorning = gettingUpInTheMorning;
        this.goingToBedLate = goingToBedLate;
        this.webUser = webUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public String getParties() {
        return parties;
    }

    public void setParties(String parties) {
        this.parties = parties;
    }

    public String getQuietRoommates() {
        return quietRoommates;
    }

    public void setQuietRoommates(String quietRoommates) {
        this.quietRoommates = quietRoommates;
    }

    public String getCookingTogether() {
        return cookingTogether;
    }

    public void setCookingTogether(String cookingTogether) {
        this.cookingTogether = cookingTogether;
    }

    public String getGettingUpInTheMorning() {
        return gettingUpInTheMorning;
    }

    public void setGettingUpInTheMorning(String gettingUpInTheMorning) {
        this.gettingUpInTheMorning = gettingUpInTheMorning;
    }

    public String getGoingToBedLate() {
        return goingToBedLate;
    }

    public void setGoingToBedLate(String goingToBedLate) {
        this.goingToBedLate = goingToBedLate;
    }

    public WebUser getWebUser() {
        return webUser;
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }
}
