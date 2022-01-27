package put.poznan.AcoPlaceBackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import put.poznan.AcoPlaceBackend.model.Announcement;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

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
