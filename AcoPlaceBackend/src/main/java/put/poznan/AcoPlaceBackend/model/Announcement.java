package put.poznan.AcoPlaceBackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
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
@ToString
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
    @Column(columnDefinition="TEXT")
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
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "CET")
    private Date availableFrom;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm", timezone = "CET")
    private Date publicationDate;

    @ManyToOne
    private WebUser webUser;

    @OneToMany
    private List<ImageStorage> images;

}
