package put.poznan.AcoPlaceBackend.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String country;
    private String city;
    private String postalCode;
    private String district;
    private String state;
    private String street;
    private String houseNumber;
    private String title;
    private String text;
    private String propertyType; //TODO change this to ENUM value
    private double price;
    private String currency; //TODO change this to ENUM value
    private int livingSpace;
    private int yearBuilt;
    private Date availableFrom;
    private Date publicationDate;

    @ManyToOne
    private WebUser webUser;

    public Announcement() {
    }

    public Announcement(long id, String country, String city, String postalCode, String district, String state, String street, String houseNumber, String title, String text, String propertyType, double price, String currency, int livingSpace, int yearBuilt, Date availableFrom, Date publicationDate, WebUser webUser) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.district = district;
        this.state = state;
        this.street = street;
        this.houseNumber = houseNumber;
        this.title = title;
        this.text = text;
        this.propertyType = propertyType;
        this.price = price;
        this.currency = currency;
        this.livingSpace = livingSpace;
        this.yearBuilt = yearBuilt;
        this.availableFrom = availableFrom;
        this.publicationDate = publicationDate;
        this.webUser = webUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(int livingSpace) {
        this.livingSpace = livingSpace;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public Date getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(Date availableFrom) {
        this.availableFrom = availableFrom;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public WebUser getWebUser() {
        return webUser;
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

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
