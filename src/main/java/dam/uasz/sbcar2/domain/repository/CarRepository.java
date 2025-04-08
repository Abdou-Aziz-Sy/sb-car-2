package dam.uasz.sbcar2.domain.repository;

import dam.uasz.sbcar2.domain.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Integer> {
    // Ajout de méthodes de recherche qui seront exposées via l'API
    Iterable<Car> findByBrand(@Param("brand") String brand);
    Iterable<Car> findByColor(@Param("color") String color);
}