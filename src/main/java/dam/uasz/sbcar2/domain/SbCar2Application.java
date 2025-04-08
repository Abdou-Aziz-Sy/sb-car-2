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
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootApplication
public class SbCar2Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SbCar2Application.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SbCar2Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Nettoyage des données existantes
        carRepository.deleteAll();
        ownerRepository.deleteAll();

        // Créer les voitures
        Car car1 = new Car("Ford", "Mustang", "Red", "2021", 1121, 59000);
        Car car2 = new Car("Nissan", "Leaf", "White", "2020", 3002, 29000);
        Car car3 = new Car("Toyota", "Prius", "Silver", "2022", 212, 39000);

        // Sauvegarder les voitures d'abord
        carRepository.saveAll(Arrays.asList(car1, car2, car3));

        // Créer les propriétaires
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");

        // Établir les relations
        owner1.getCars().add(car1);
        owner1.getCars().add(car2);
        owner2.getCars().add(car2);  // Notez que car2 appartient maintenant à 2 propriétaires
        owner2.getCars().add(car3);

        // Sauvegarder les propriétaires
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        // Afficher les relations
        logger.info("Owners and their cars:");
        for (Owner owner : ownerRepository.findAll()) {
            logger.info("Owner: {} {}", owner.getFirstName(), owner.getLastName());
            for (Car car : owner.getCars()) {
                logger.info(" - Car: {} {}, {}", car.getBrand(), car.getModel(), car.getColor());
            }
        }

        logger.info("Cars and their owners:");
        for (Car car : carRepository.findAll()) {
            logger.info("Car: {} {}", car.getBrand(), car.getModel());
            for (Owner owner : car.getOwners()) {
                logger.info(" - Owner: {} {}", owner.getFirstName(), owner.getLastName());
            }
        }
    }
}