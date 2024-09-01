package Repository;

import Dto.Location;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.CrudRepository;


public interface LocationRepository extends CrudRepository<Location, String> {
}
