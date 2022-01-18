package put.poznan.AcoPlaceBackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "CET")
    private Date availableFrom;
}
