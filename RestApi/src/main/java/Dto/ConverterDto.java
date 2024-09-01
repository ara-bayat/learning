package Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConverterDto {
    private String fromUnit;
    private Double fromValue;
    private String toUnit;
    private Double toValue;

}
