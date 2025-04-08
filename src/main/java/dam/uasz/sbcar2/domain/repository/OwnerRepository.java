package dam.uasz.sbcar2.domain.repository;

import dam.uasz.sbcar2.domain.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OwnerRepository extends CrudRepository<Owner, Integer> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}