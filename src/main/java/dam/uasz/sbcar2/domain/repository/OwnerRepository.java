package dam.uasz.sbcar2.domain.repository;

import dam.uasz.sbcar2.domain.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
    // This interface will automatically provide CRUD operations for the Owner entity
    // No need to implement any methods, Spring Data JPA will handle it
}
