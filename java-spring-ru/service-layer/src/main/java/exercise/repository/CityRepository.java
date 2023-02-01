package exercise.repository;

import exercise.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    // BEGIN
    List<City> findAllByOrderByNameAsc();
    List<City> findByNameStartingWithIgnoreCase(String prefix);
    // END
}
