package com.abozied.Observer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class WeatherLogger implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        System.out.printf("[%s] WeatherLogger Temp: %.1f°C, Humidity: %.1f%%, Pressure: %.1f hPa%n",
                now.format(formatter), temperature, humidity, pressure);
    }
}
