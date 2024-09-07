package org.restapi.restapi;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;


    public Location addLocation(Location location) {
        return locationRepository.save(location);

    }

    public List<Location> findUntrashedLocations(){
        return locationRepository.findUntrashed();
    }

    public Location findByCode(String code){
        return locationRepository.findByCode(code);
    }



}
