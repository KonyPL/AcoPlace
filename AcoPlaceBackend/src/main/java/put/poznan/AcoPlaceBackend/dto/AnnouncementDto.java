package put.poznan.AcoPlaceBackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import put.poznan.AcoPlaceBackend.model.Announcement;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AnnouncementDto {
    @EqualsAndHashCode.Include
    private Integer id;
    private String country;
    private String city;
    private String district;
    private String state;
    private String title;
    private String propertyType;
    private Double price;
    private String currency;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "CET")
    private Date availableFrom;
    private List<String> images;

    public AnnouncementDto(Integer id, String country, String city, String district, String state, String title,
                           String propertyType, Double price, String currency, Date availableFrom){
        this.id = id;
        this.country = country;
        this.city = city;
        this.district = district;
        this.state = state;
        this.title = title;
        this.propertyType = propertyType;
        this.price = price;
        this.currency = currency;
        this.availableFrom = availableFrom;
    }
    public AnnouncementDto makeFromModel(Announcement announcement){
        this.id = announcement.getId();
        this.country = announcement.getCountry();
        this.city = announcement.getCity();
        this.district = announcement.getDistrict();
        this.state = announcement.getState();
        this.title = announcement.getTitle();
        this.propertyType = announcement.getPropertyType();
        this.price = announcement.getPrice();
        this.currency = announcement.getCurrency();
        this.availableFrom = announcement.getAvailableFrom();
        return this;
    }
}
