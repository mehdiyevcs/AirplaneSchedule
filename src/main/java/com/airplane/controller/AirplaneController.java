package com.airplane.controller;

import com.airplane.service.AirplaneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
@AllArgsConstructor
public class AirplaneController {

    private AirplaneService airplaneService;

    @GetMapping("/airplane")
    public String getSchedule(@RequestParam String numOfAirplanes,
                              @RequestParam String numOfAreas,
                              @RequestParam String numOfCities,
                              @RequestParam HashMap<String,String> cityParams) throws IOException {
        return airplaneService.getSchedule(cityParams);
    }

}
