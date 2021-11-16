package put.poznan.AcoPlaceBackend.model.OLD;

import put.poznan.AcoPlaceBackend.model.Announcement;

import javax.persistence.*;
import java.util.List;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String address;
    @OneToMany
    private List<Flatmate> flatmates;
    @ManyToOne
    private Owner owner;
    @OneToMany
    private List<Announcement> announcements;

    public Place(long id, String type, String address, List<Flatmate> flatmates, Owner owner, List<Announcement> announcements) {
        this.id = id;
        this.type = type;
        this.address = address;
        this.flatmates = flatmates;
        this.owner = owner;
        this.announcements = announcements;
    }

    public Place() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Flatmate> getFlatmates() {
        return flatmates;
    }

    public void setFlatmates(List<Flatmate> flatmates) {
        this.flatmates = flatmates;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", flatmates=" + flatmates +
                ", owner=" + owner +
                ", announcements=" + announcements +
                '}';
    }
}
