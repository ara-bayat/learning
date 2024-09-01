package Controller;

import Dto.Location;
import Service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/V1/locations")
public class LocationApiController {
    private final LocationService locationService;

    public LocationApiController(LocationService locationService) {
        super();
        this.locationService = locationService;
    }
    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location addedLocation = locationService.addLocation(location);
        URI uri=URI.create("/V1/locations/"+location.getCode());
        return ResponseEntity.created(uri).body(addedLocation);
    }

}
