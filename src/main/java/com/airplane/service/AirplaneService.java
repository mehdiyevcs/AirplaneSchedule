package com.airplane.service;

import com.airplane.model.ResponseSchedule;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

import static com.airplane.constant.ApplicationConstant.*;

@Service
public class AirplaneService {



    public String getSchedule(Map<String,String> cityParams) throws IOException {
        ProcessBuilder pb = new  ProcessBuilder(COMMAND_NAME,SCRYPT_NAME);
        pb.directory(new File(DIRECTORY_NAME));
        Process process = pb.start();
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

        String line;
        for (Map.Entry<String, String> city: cityParams.entrySet()) {
            if(city.getKey().equals("numOfAirplanes") ||
                    city.getKey().equals("numOfAreas") ||
                    city.getKey().equals("numOfCities")) {
                writer.write(String.valueOf(city.getValue()));
                writer.newLine();
            }else{
            writer.write(city.getKey()+" "+city.getValue()); writer.newLine();
            }
        }
        writer.flush();
        writer.close();

        while ((line = reader.readLine()) != null ) {
            builder.append(line+"\n");
        }
        reader.close();
        process.destroy();
        return builder.toString();
    };

    public List<ResponseSchedule> getScheduleFromUI(String numOfAirplanes,
                                                    String numOfAreas,
                                                    String numOfCities,
                                                    String cityParams) throws Exception {
        return getScheduleList(convertStringToMap(numOfAirplanes, numOfAreas, numOfCities, cityParams));
    }

    public LinkedHashMap<String,String> convertStringToMap(String numOfAirplanes,
                                                 String numOfAreas,
                                                 String numOfCities,
                                                 String cityParams) throws Exception {

        String arrCities [] = cityParams.split("\\W+");
        LinkedHashMap<String,String> listCities = new LinkedHashMap<>();

        if(arrCities.length%2==0){
            listCities.put("numOfAirplanes",numOfAirplanes);
            listCities.put("numOfAreas",numOfAreas);
            listCities.put("numOfCities",numOfCities);
            for(int i=0;i<arrCities.length-1;i=i+2) {
                listCities.put(arrCities[i],arrCities[i+1]);
            }
        }else{
            throw new Exception("City params are not right");
        }
        return listCities;
    }

    public List<ResponseSchedule> getScheduleList(Map<String,String> cityParams) throws IOException {

        String out[] = getSchedule(cityParams)
                .split("\\s+");
        List<ResponseSchedule> responseSchedules = new ArrayList<>();
        for(int i=0;i<out.length-7;i=i+8){
            String leaveTime = ""+Math.round(Float.parseFloat(out[i+2])*100.0)/100.0;
            String backTime = ""+Math.round(Float.parseFloat(out[i+4])*100.0)/100.0;
            responseSchedules.add(new ResponseSchedule(out[i],out[i+1],leaveTime,out[i+3],backTime,out[i+5],out[i+6],out[i+7]));
        }
        return responseSchedules;
    }

}
