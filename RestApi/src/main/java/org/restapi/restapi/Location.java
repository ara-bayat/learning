package org.restapi.restapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @Column(length = 12, nullable = false,unique = true)
    private String code;

    @Column(length = 128, nullable = false)
    @JsonProperty("city_name")
    private String cityName;

    @Column(length = 128, nullable = false)
    private String regionName;

    @Column(length = 128, nullable = false)
    private String countryName;

    @Column(length = 2, nullable = false)
    private String regionCode;

    private boolean enabled ;
    private boolean trashed;

}
