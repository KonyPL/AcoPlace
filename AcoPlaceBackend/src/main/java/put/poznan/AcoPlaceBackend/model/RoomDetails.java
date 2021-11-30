package put.poznan.AcoPlaceBackend.model;

import javax.persistence.*;

@Entity
public class RoomDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int floor;
    private int bedsInRoom;
    private int numberOfFlatmates;
    private int bathrooms;

    @ManyToOne
    private Announcement announcement;

    public RoomDetails(Long id, int floor, int bedsInRoom, int numberOfFlatmates, int bathrooms, Announcement announcement) {
        this.id = id;
        this.floor = floor;
        this.bedsInRoom = bedsInRoom;
        this.numberOfFlatmates = numberOfFlatmates;
        this.bathrooms = bathrooms;
        this.announcement = announcement;
    }

    public RoomDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getBedsInRoom() {
        return bedsInRoom;
    }

    public void setBedsInRoom(int bedsInRoom) {
        this.bedsInRoom = bedsInRoom;
    }

    public int getNumberOfFlatmates() {
        return numberOfFlatmates;
    }

    public void setNumberOfFlatmates(int numberOfFlatmates) {
        this.numberOfFlatmates = numberOfFlatmates;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Announcement getAdvertisement() {
        return announcement;
    }

    public void setAdvertisement(Announcement announcement) {
        this.announcement = announcement;
    }
}
