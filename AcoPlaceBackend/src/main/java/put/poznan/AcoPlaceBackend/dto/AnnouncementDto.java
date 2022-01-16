package put.poznan.AcoPlaceBackend.dto;

import lombok.*;

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
    private Date availableFrom;
}
