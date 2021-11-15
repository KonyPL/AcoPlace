package put.poznan.AcoPlaceBackend.model;

import javax.persistence.*;

@Entity
public class HouseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int floors;
    private boolean basement;
    private int bedrooms;
    private int bathrooms;
    private int lotSize;
    private boolean parking;
    private int balcony;

    @ManyToOne
    private Advertisement advertisement;

    public HouseDetails() {
    }

    public HouseDetails(Long id, int floors, boolean basement, int bedrooms, int bathrooms, int lotSize, boolean parking, int balcony, Advertisement advertisement) {
        this.id = id;
        this.floors = floors;
        this.basement = basement;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.lotSize = lotSize;
        this.parking = parking;
        this.balcony = balcony;
        this.advertisement = advertisement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public boolean isBasement() {
        return basement;
    }

    public void setBasement(boolean basement) {
        this.basement = basement;
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

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public int getBalcony() {
        return balcony;
    }

    public void setBalcony(int balcony) {
        this.balcony = balcony;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
}
