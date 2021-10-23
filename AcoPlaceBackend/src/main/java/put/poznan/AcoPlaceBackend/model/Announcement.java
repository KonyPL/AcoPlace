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
    private User user;
    @OneToOne
    private Place place;

    public Announcement(long id, Date publicationDate, String description, User user, Place place) {
        this.id = id;
        this.publicationDate = publicationDate;
        this.description = description;
        this.user = user;
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
                ", user=" + user +
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
