package dam.uasz.sbcar2.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Identifiant unique de la voiture")
    private int id;
    @Schema(description = "Marque de la voiture")
    private String brand;
    @Schema(description = "Modèle de la voiture")
    private String model;
    @Schema(description = "Couleur de la voiture")
    private String color;
    @Schema(description = "Année du modèle")
    private String modelYear;
    @Schema(description = "Numéro d'immatriculation")
    private int registerNumber;
    @Schema(description = "Prix de la voiture")
    private int price;

    @ManyToMany(mappedBy = "cars")
    private Set<Owner> owners = new HashSet<>();

    public Car() {
    }

    public Car(String brand, String model, String color, String modelYear, int registerNumber, int price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.modelYear = modelYear;
        this.registerNumber = registerNumber;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }
}
