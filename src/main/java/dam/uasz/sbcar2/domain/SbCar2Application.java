package dam.uasz.sbcar2.domain;

import dam.uasz.sbcar2.domain.model.Car;
import dam.uasz.sbcar2.domain.model.Owner;
import dam.uasz.sbcar2.domain.repository.CarRepository;
import dam.uasz.sbcar2.domain.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbCar2Application  implements CommandLineRunner {

    private static final Logger logger =
            LoggerFactory.getLogger(SbCar2Application.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SbCar2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Ajouter des propriétaires
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");
        ownerRepository.save(owner1);
        ownerRepository.save(owner2);

        // Ajouter des voitures avec propriétaires
        Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 59000, 2021);
        car1.setOwner(owner1);
        carRepository.save(car1);

        Car car2 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 29000, 2020);
        car2.setOwner(owner2);
        carRepository.save(car2);

        Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 39000, 2022);
        car3.setOwner(owner2);
        carRepository.save(car3);

        // Afficher toutes les voitures avec leurs propriétaires
        for (Car car : carRepository.findAll()) {
            logger.info("Brand: {}, Model: {}, Owner: {} {}",
                    car.getBrand(), car.getModel(),
                    car.getOwner().getFirstName(), car.getOwner().getLastName());
        }
    }

}
