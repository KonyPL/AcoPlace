package put.poznan.AcoPlaceBackend.model;

import javax.persistence.*;

@Entity
public class WebUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private boolean verified;

    public WebUser() {
    }


}
