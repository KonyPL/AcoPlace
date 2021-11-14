package put.poznan.AcoPlaceBackend.model.OLD;

import javax.persistence.*;

@Entity
public class Flatmate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int age;

    @ManyToOne
    private Place place;

    public Flatmate(Long id, String name, String description, int age, Place place) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.age = age;
        this.place = place;
    }

    public Flatmate() {
    }

    @Override
    public String toString() {
        return "Flatmate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                ", place=" + place +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
