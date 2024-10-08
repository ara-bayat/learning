package org.restapi.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/V1/locations")
public class LocationApiController {
    @Autowired
    private LocationService locationService;


    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location addedLocation = locationService.addLocation(location);
        URI uri=URI.create("/V1/locations/"+location.getCode());
        return ResponseEntity.created(uri).body(addedLocation);
    }


    @GetMapping
    public ResponseEntity<?> findUntrashedLocations() {
        var locations=locationService.findUntrashedLocations();
        if(locations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(locations);
    }
    @GetMapping("/{code}")
    public ResponseEntity<?> findByCode(@PathVariable("code") String code) {
        var locations=locationService.findByCode(code);
        if(locations== null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(locations);
    }
}
