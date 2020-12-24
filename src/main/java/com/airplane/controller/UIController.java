package com.airplane.controller;

import com.airplane.model.ResponseSchedule;
import com.airplane.service.AirplaneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class UIController {

    private AirplaneService airplaneService;

    @GetMapping("/schedule")
    public String getHome(){
        return "CreateSchedule.jsp";
    }

    @PostMapping(value = "createSchedule")
    public ModelAndView createSchedule(@RequestParam String numOfAirplanes,
                                                              @RequestParam String numOfAreas,
                                                              @RequestParam String numOfCities,
                                                              @RequestParam String list) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result.jsp");
        mv.addObject("responseSchedules",
                airplaneService.getScheduleFromUI(numOfAirplanes,numOfAreas,numOfCities,list));
        return mv;
    }

}
