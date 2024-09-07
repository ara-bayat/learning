package org.restapi.restapi;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class LocationRepositoryTests {
    @Autowired
    private LocationRepository repository;

    @Test
    public void TestListSuccess()
    {
        List<Location> locations = repository.findUntrashed();
        org.junit.Assert.assertNotSame(locations,null);
    }



}
