package put.poznan.AcoPlaceBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto {
    private Integer id;
    private String userName;
    private String email;
    //USERDETAILS
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String countryCode;
    private String about;
}