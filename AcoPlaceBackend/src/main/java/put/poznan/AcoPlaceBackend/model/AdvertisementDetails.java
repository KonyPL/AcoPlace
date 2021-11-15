package put.poznan.AcoPlaceBackend.model;

import javax.persistence.*;

@Entity
public class AdvertisementDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private int internetSpeed;
    private boolean internet;
    private boolean tv;
    private boolean dishwasher;
    private boolean clothesDryer;
    private boolean nearShoppingMall;
    private boolean nearBakery;
    private boolean nearFoodMarket;
    private boolean nearSupermarket;

    @ManyToOne
    private Advertisement advertisement;

    public AdvertisementDetails() {
    }

    public AdvertisementDetails(Long id, boolean bath, boolean shower, boolean microwave, boolean oven, boolean petsAllowed, boolean elevator, boolean nearPark, boolean fenced, boolean nearTram, boolean nearBus, boolean wifi, boolean ethernetOutlets, int internetSpeed, boolean internet, boolean tv, boolean dishwasher, boolean clothesDryer, boolean nearShoppingMall, boolean nearBakery, boolean nearFoodMarket, boolean nearSupermarket, Advertisement advertisement) {
        this.id = id;
        this.bath = bath;
        this.shower = shower;
        this.microwave = microwave;
        this.oven = oven;
        this.petsAllowed = petsAllowed;
        this.elevator = elevator;
        this.nearPark = nearPark;
        this.fenced = fenced;
        this.nearTram = nearTram;
        this.nearBus = nearBus;
        this.wifi = wifi;
        this.ethernetOutlets = ethernetOutlets;
        this.internetSpeed = internetSpeed;
        this.internet = internet;
        this.tv = tv;
        this.dishwasher = dishwasher;
        this.clothesDryer = clothesDryer;
        this.nearShoppingMall = nearShoppingMall;
        this.nearBakery = nearBakery;
        this.nearFoodMarket = nearFoodMarket;
        this.nearSupermarket = nearSupermarket;
        this.advertisement = advertisement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBath() {
        return bath;
    }

    public void setBath(boolean bath) {
        this.bath = bath;
    }

    public boolean isShower() {
        return shower;
    }

    public void setShower(boolean shower) {
        this.shower = shower;
    }

    public boolean isMicrowave() {
        return microwave;
    }

    public void setMicrowave(boolean microwave) {
        this.microwave = microwave;
    }

    public boolean isOven() {
        return oven;
    }

    public void setOven(boolean oven) {
        this.oven = oven;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public boolean isNearPark() {
        return nearPark;
    }

    public void setNearPark(boolean nearPark) {
        this.nearPark = nearPark;
    }

    public boolean isFenced() {
        return fenced;
    }

    public void setFenced(boolean fenced) {
        this.fenced = fenced;
    }

    public boolean isNearTram() {
        return nearTram;
    }

    public void setNearTram(boolean nearTram) {
        this.nearTram = nearTram;
    }

    public boolean isNearBus() {
        return nearBus;
    }

    public void setNearBus(boolean nearBus) {
        this.nearBus = nearBus;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isEthernetOutlets() {
        return ethernetOutlets;
    }

    public void setEthernetOutlets(boolean ethernetOutlets) {
        this.ethernetOutlets = ethernetOutlets;
    }

    public int getInternetSpeed() {
        return internetSpeed;
    }

    public void setInternetSpeed(int internetSpeed) {
        this.internetSpeed = internetSpeed;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isDishwasher() {
        return dishwasher;
    }

    public void setDishwasher(boolean dishwasher) {
        this.dishwasher = dishwasher;
    }

    public boolean isClothesDryer() {
        return clothesDryer;
    }

    public void setClothesDryer(boolean clothesDryer) {
        this.clothesDryer = clothesDryer;
    }

    public boolean isNearShoppingMall() {
        return nearShoppingMall;
    }

    public void setNearShoppingMall(boolean nearShoppingMall) {
        this.nearShoppingMall = nearShoppingMall;
    }

    public boolean isNearBakery() {
        return nearBakery;
    }

    public void setNearBakery(boolean nearBakery) {
        this.nearBakery = nearBakery;
    }

    public boolean isNearFoodMarket() {
        return nearFoodMarket;
    }

    public void setNearFoodMarket(boolean nearFoodMarket) {
        this.nearFoodMarket = nearFoodMarket;
    }

    public boolean isNearSupermarket() {
        return nearSupermarket;
    }

    public void setNearSupermarket(boolean nearSupermarket) {
        this.nearSupermarket = nearSupermarket;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
}
