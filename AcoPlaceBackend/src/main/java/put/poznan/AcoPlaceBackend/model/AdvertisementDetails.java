package put.poznan.AcoPlaceBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdvertisementDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private int internetSpeed;
    private boolean internet;
    private boolean tv;
    private boolean dishwasher;
    private boolean clothesDryer;
    private boolean nearShoppingMall;
    private boolean nearBakery;
    private boolean nearFoodMarket;
    private boolean nearSupermarket;
}
