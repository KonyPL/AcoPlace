package put.poznan.AcoPlaceBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
