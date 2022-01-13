package put.poznan.AcoPlaceBackend.model;

public class UserNameDto {

    String name;

    public UserNameDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserNameDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
