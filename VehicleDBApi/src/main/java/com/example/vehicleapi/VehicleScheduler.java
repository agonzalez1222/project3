package com.example.vehicleapi;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class VehicleScheduler {
    RestTemplate restTemplate = new RestTemplate();
    String[] make = new String[20];
    int count = 1;

    public void setCount(int count) {
        this.count = count;
    }

    @Scheduled(cron = "*/1 * * * * *")
    public void addVehicle() {
        String url = "http://localhost:8080/addVehicle";
        make[0] = "VW Jetta";
        make[1] = "Toyota Corolla ";
        make[2] = "Toyota Camry ";
        make[3] = "Honda Accord";
        make[4] = "Honda CR-V";
        make[6] = "Honda Civic";
        make[7] = "Toyota Tacoma";
        make[8] = "Toyota Highlander";
        make[9] = "Ford F-150";
        make[10] = "Honda Pilot";
        make[11] = "Jeep Cherokee";
        make[12] = "Mazda CX-5";
        make[13] = "Chevy Transverse";
        make[14] = "Toyota RAV4";
        make[15] = "Subaru Outback";
        make[16] = "BMW X3";
        make[17] = "Jeep Wrangler";
        make[18] = "Chevy Equinox";
        make[19] = "Subaru Forester";
        Random r = new Random();
        int year = r.nextInt(2016 - 1986 + 1) + 1986;
        double cost = r.nextInt(4500 - 1500 + 1) + 1500.00;
        int generator = r.nextInt((18 - 0 + 1) + 0);
        String test = make[generator];
        Vehicle random = new Vehicle(count, test, year, cost);
        Vehicle v = restTemplate.postForObject(url, random, Vehicle.class);
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void deleteVehicle()
    {
        Random r = new Random();
        int ran = r.nextInt(150 - 1 + 1) + 1;
        String url = ("http://localhost:8080/getVehicle/" + ran);
        String delete = ("http://localhost:8080/deleteVehicle/" + ran);
        Vehicle test = restTemplate.getForObject(url, Vehicle.class);
        if (test != null)
        {
            restTemplate.delete(delete);
            System.out.println(ran + "Deleted");
        }
    }

    @Scheduled(cron ="*/5 * * * * *")
    public void updateVehicle()
    {
        Random r = new Random();
        int ran = r.nextInt(150 - 1 + 1) + 1;
        Vehicle trick = new Vehicle(ran, "WOOOT WOOT", 1111, 1111);
        String getUrl = "http://localhost:8080/getVehicle/" + ran;
        String url = "http://localhost:8080/updateVehicle";
        Vehicle test = restTemplate.getForObject(getUrl, Vehicle.class);
        if(test != null)
        {
            restTemplate.put(url, trick, Vehicle.class);
            System.out.println("Updated: " + test);
        }

    }
}

