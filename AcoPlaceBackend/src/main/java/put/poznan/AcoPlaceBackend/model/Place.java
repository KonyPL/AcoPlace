package put.poznan.AcoPlaceBackend.model;

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
    @OneToOne
    private Announcement announcement;

    public Place(long id, String type, String address, List<Flatmate> flatmates, Owner owner, Announcement announcement) {
        this.id = id;
        this.type = type;
        this.address = address;
        this.flatmates = flatmates;
        this.owner = owner;
        this.announcement = announcement;
    }

    public Place() {
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", flatmates=" + flatmates +
                ", owner=" + owner +
                ", announcement=" + announcement +
                '}';
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

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }
}
