package dam.uasz.sbcar2.domain.repository;

import dam.uasz.sbcar2.domain.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
    // This interface will automatically provide CRUD operations for the Car entity
    // No need to implement any methods, Spring Data JPA will handle it
}
