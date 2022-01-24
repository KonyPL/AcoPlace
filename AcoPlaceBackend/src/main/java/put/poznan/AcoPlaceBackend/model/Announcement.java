package put.poznan.AcoPlaceBackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import put.poznan.AcoPlaceBackend.dto.AnnouncementDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMapping(
        name = "AnnouncementDtoMapping",
        classes = {
                @ConstructorResult(
                        targetClass = AnnouncementDto.class,
                        columns = {
                                @ColumnResult(name = "a_id", type = Integer.class),
                                @ColumnResult(name = "country", type = String.class),
                                @ColumnResult(name = "city", type = String.class),
                                @ColumnResult(name = "district", type = String.class),
                                @ColumnResult(name = "state", type = String.class),
                                @ColumnResult(name = "title", type = String.class),
                                @ColumnResult(name = "property_type", type = String.class),
                                @ColumnResult(name = "price", type = Double.class),
                                @ColumnResult(name = "currency", type = String.class),
                                @ColumnResult(name = "available_from", type = Date.class)
                        }
                ),
        }
)
public class Announcement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Boolean reported;
    private String reason;
    private String description;
    private String admin;
    private String reportedTime;
    private Boolean edited;
    private Boolean active;
    private Boolean editedByUser;


    @Temporal(TemporalType.DATE)
    private Date availableFrom;

    private Date publicationDate;

    @ManyToOne
    private WebUser webUser;

    @OneToMany
    private List<ImageStorage> images;

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", livingSpace=" + livingSpace +
                ", yearBuilt=" + yearBuilt +
                ", availableFrom=" + availableFrom +
                ", publicationDate=" + publicationDate +
                ", webUser=" + webUser +
                '}';
    }
}
