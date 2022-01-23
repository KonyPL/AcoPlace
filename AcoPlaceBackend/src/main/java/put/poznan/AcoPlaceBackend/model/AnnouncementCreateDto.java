package put.poznan.AcoPlaceBackend.model;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnnouncementCreateDto {
    private Integer id;
    private String country;
    private String city;
    private String postalCode;
    private String district;
    private String state;
    private String street;
    private String houseNumber;
    private String title;
    private String text;
    private String propertyType;
    private Double price;
    private String currency;
    private Integer livingSpace;
    private Integer yearBuilt;
    //Admin
   /* private Boolean reported;
    private String reason;
    private String description;
    private String admin;
    private String reportedTime;
    private Boolean edited;
    private Boolean active;*/


    @Temporal(TemporalType.DATE)
    private Date availableFrom;

    private Date publicationDate;

    //web user id dodac to do czegos
    private Integer webUserId;

    //ANNOUNCEMENT DETAILS INFO
    private boolean bath;
    private boolean shower;
    private boolean microwave;
    private boolean oven;
    private boolean petsAllowed;
    private boolean elevator;
    private boolean nearPark;
    private boolean fenced;
    private boolean nearTram;
    private boolean nearBus;
    private boolean wifi;
    private boolean ethernetOutlets;
    private Integer internetSpeed;
    private boolean internet;
    private boolean tv;
    private boolean dishwasher;
    private boolean clothesDryer;
    private boolean nearShoppingMall;
    private boolean nearBakery;
    private boolean nearFoodMarket;
    private boolean nearSupermarket;

    //Flat details
    private Boolean basement;
    private Integer floor;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer flatParking;
    private Integer balcony;
    //House Details
    private Integer floors;
    private Integer lotSize;
    private Boolean parking;
    //Room Details
    private Integer bedsInRoom;
    private Integer numberOfFlatmates;


}
