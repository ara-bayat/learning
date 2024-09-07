package org.restapi.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/converter")
public class ConverterApiController {
    @PostMapping()
    public ConverterDto Converter(@RequestBody ConverterDto converterDto) {

        converterDto.setToValue(11.0);
        return converterDto;
    }
    @GetMapping()
    public ResponseEntity<?> getEntity(@RequestBody ConverterDto converterDto) {
        return ResponseEntity.noContent().build();
    }
}
