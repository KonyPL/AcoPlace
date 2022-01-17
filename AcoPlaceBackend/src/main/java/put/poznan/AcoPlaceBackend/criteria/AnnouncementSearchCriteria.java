package put.poznan.AcoPlaceBackend.criteria;

import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import put.poznan.AcoPlaceBackend.model.FlatDetails;
import put.poznan.AcoPlaceBackend.model.HouseDetails;
import put.poznan.AcoPlaceBackend.model.RoomDetails;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

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

    private Boolean detailsPresent;
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

        private Boolean detailsPresent;
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
        private Boolean internet;
        private Boolean tv;
        private Boolean dishwasher;
        private Boolean clothesDryer;
        private Boolean nearShoppingMall;
        private Boolean nearBakery;
        private Boolean nearFoodMarket;
        private Boolean nearSupermarket;

        public AnnouncementSearchCriteriaBuilder title(String title) {
            this.title = (title != null) ? "%" + title + "%" : null;
            return this;
        }

        public AnnouncementSearchCriteriaBuilder mustHave(String mustHave) {
            if( mustHave == null ){ return this; } else { this.detailsPresent = true; }
//            this.bath = mustHave.contains("bath") ? true : null;
//            this.shower = mustHave.contains("shower") ? true : null;
//            this.microwave = mustHave.contains("microwave") ? true : null;
//            this.oven = mustHave.contains("oven") ? true : null;
//            this.petsAllowed = mustHave.contains("petsAllowed") ? true : null;
//            this.elevator = mustHave.contains("elevator") ? true : null;
//            this.nearPark = mustHave.contains("nearPark") ? true : null;

            String[] params = {"bath","shower","microwave","oven","petsAllowed","elevator","nearPark"};
            //for each param in list
            for (String param : params) {
                try {
                    //get value of private field "param" from criteria
                    Field field = AnnouncementSearchCriteriaBuilder.class.getDeclaredField(param);
                    field.setAccessible(true);
                    Boolean value = (Boolean) field.get(this);
                    //if mustHave contains string "param": set private field "param" to true, otherwise null
                    field.set(this, (mustHave.contains(param) ? true : null));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return this;
        }


    }

    public Map<String, Object> buildQueryParameters() {
        //create new HashMap
        Map<String, Object> result = Maps.newHashMap();
        //check if both priceMin and priceMax have values other than null
        //add both values to HashMap
        if (ObjectUtils.allNotNull(priceMin, priceMax)) {
            result.put("priceMin", priceMin);
            result.put("priceMax", priceMax);
        }
        if (detailsPresent != null) result.put("detailsPresent", detailsPresent);
        //create a list of all possible params for easier bind
        String[] params = {"availableFrom","title","propertyType","livingSpace","internetSpeed","bath","shower",
                "microwave","oven","petsAllowed","elevator","nearPark"};
        //for each param in list
        for (String param : params) {
            try {
                //get value of private field "param" from criteria
                Field field = AnnouncementSearchCriteria.class.getDeclaredField(param);
                field.setAccessible(true);
                Object object = field.get(this);
                if (object != null) result.put(param, object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        if (criteria.getTitle() != null) {
//            result.put("title", criteria.getTitle());
//        }
//        if (criteria.getPropertyType() != null) {
//            result.put("propertyType", criteria.getPropertyType());
//        }
//        if (criteria.getLivingSpace() != null) {
//            result.put("livingSpace", criteria.getLivingSpace());
//        }
//        if (criteria.getInternetSpeed() != null) {
//            result.put("internetSpeed", criteria.getInternetSpeed());
//        }
//        if (criteria.getBath() != null) {
//            result.put("bath", criteria.getBath());
//        }
//        if (criteria.getShower() != null) {
//            result.put("shower", criteria.getShower());
//        }
        return result;
    }
}
