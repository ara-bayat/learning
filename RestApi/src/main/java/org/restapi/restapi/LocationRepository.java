package org.restapi.restapi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, String> {

    @Query("SELECT l FROM Location l WHERE l.trashed=false")
    public List<Location> findUntrashed();

    @Query("SELECT l FROM Location l WHERE l.trashed=false AND l.code=?1")
    public Location findByCode(String code);
}
