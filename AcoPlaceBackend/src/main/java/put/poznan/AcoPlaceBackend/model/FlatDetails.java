package put.poznan.AcoPlaceBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
