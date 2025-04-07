package dam.uasz.sbcar2.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Owner {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String firstName;
private String lastName;

@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
private List<Car> cars;

public Owner() {}

public Owner(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
