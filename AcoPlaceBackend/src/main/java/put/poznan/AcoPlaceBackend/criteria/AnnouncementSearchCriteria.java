package put.poznan.AcoPlaceBackend.criteria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import put.poznan.AcoPlaceBackend.model.FlatDetails;
import put.poznan.AcoPlaceBackend.model.HouseDetails;
import put.poznan.AcoPlaceBackend.model.RoomDetails;

import java.util.Date;

@Getter
@Setter
@Builder

public class AnnouncementSearchCriteria {
    private String title;
    private Double priceMin;
    private Double priceMax;
    private String propertyType;
    private Integer livingSpace;
    private Date availableFrom;

    private Boolean bath;
    private Boolean shower;
    private Boolean microwave;
    private Boolean oven;
    private Boolean petsAllowed;
    private Boolean elevator;
    private Boolean nearPark;
    private Boolean fenced;
    private Boolean nearTram;
    private Boolean nearBus;
    private Boolean wifi;
    private Boolean ethernetOutlets;
    private Integer internetSpeed;
    private Boolean internet;
    private Boolean tv;
    private Boolean dishwasher;
    private Boolean clothesDryer;
    private Boolean nearShoppingMall;
    private Boolean nearBakery;
    private Boolean nearFoodMarket;
    private Boolean nearSupermarket;

    private String country;
    private String city;
    private String postalCode;
    private String district;
    private String state;
    private String street;
    private FlatDetails flatDetails;
    private RoomDetails roomDetails;
    private HouseDetails houseDetails;

    public static class AnnouncementSearchCriteriaBuilder{
        private String title;

        public AnnouncementSearchCriteriaBuilder title(String title) {
            if(title != null) {
                this.title = "%" + title + "%";
            } else {
                this.title = null;
            }
            return this;
        }
    }
}
