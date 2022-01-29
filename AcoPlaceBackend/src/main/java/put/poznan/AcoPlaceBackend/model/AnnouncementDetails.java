package put.poznan.AcoPlaceBackend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class AnnouncementDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean bath;
    private boolean shower;
    private boolean microwave;
    private boolean oven;
    private boolean petsAllowed;
    private boolean elevator;
    private boolean nearPark;
    private boolean fenced;
    private boolean nearTram;
    private boolean nearBus;
    private boolean wifi;
    private boolean ethernetOutlets;
    private Integer internetSpeed;
    private boolean internet;
    private boolean tv;
    private boolean dishwasher;
    private boolean clothesDryer;
    private boolean nearShoppingMall;
    private boolean nearBakery;
    private boolean nearFoodMarket;
    private boolean nearSupermarket;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Announcement announcement;

}
