package put.poznan.AcoPlaceBackend.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date publicationDate;
    private String description;
    @ManyToOne
    private WebUser webUser;
    @ManyToOne
    private Place place;

    public Announcement(long id, Date publicationDate, String description, WebUser webUser, Place place) {
        this.id = id;
        this.publicationDate = publicationDate;
        this.description = description;
        this.webUser = webUser;
        this.place = place;
    }

    public Announcement() {
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", publicationDate=" + publicationDate +
                ", description='" + description + '\'' +
                ", user=" + webUser +
                ", place=" + place +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WebUser getUser() {
        return webUser;
    }

    public void setUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
