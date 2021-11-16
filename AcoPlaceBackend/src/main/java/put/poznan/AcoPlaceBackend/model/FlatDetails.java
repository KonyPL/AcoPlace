package put.poznan.AcoPlaceBackend.model;

import javax.persistence.*;

@Entity
public class FlatDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean basement;
    private int floor;
    private int bedrooms;
    private int bathrooms;
    private int flatParking;
    private int balcony;

    @ManyToOne
    private Announcement announcement;

    public FlatDetails() {
    }

    public FlatDetails(Long id, boolean basement, int floor, int bedrooms, int bathrooms, int flatParking, int balcony, Announcement announcement) {
        this.id = id;
        this.basement = basement;
        this.floor = floor;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.flatParking = flatParking;
        this.balcony = balcony;
        this.announcement = announcement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBasement() {
        return basement;
    }

    public void setBasement(boolean basement) {
        this.basement = basement;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getFlatParking() {
        return flatParking;
    }

    public void setFlatParking(int flatParking) {
        this.flatParking = flatParking;
    }

    public int getBalcony() {
        return balcony;
    }

    public void setBalcony(int balcony) {
        this.balcony = balcony;
    }

    public Announcement getAdvertisement() {
        return announcement;
    }

    public void setAdvertisement(Announcement announcement) {
        this.announcement = announcement;
    }
}
