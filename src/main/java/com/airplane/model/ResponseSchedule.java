package com.airplane.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseSchedule {

    private String airplane;
    private String weekLeaveDay;
    private String leaveTime;
    private String backDay;
    private String backTime;
    private String leaveRoad;
    private String leaveCity;
    private String backRoad;

}
