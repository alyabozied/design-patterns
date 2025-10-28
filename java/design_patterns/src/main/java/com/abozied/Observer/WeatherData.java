package com.abozied.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherData implements WeatherSubject{
    private float temperature;
    private float humidity;
    private float pressure;
    private Random random = new Random();
    private List<WeatherObserver> observers;


    public WeatherData() {
        observers = new ArrayList<>();
        temperature = 20.0f;
        humidity = 65.0f;
        pressure = 1013.0f;
    }

    public void simulateRandomWeatherChange() {
        Random random = new Random();

        // Generate small random changes for realism
        float tempChange = -2 + random.nextFloat() * 4;      // -2°C to +2°C
        float humidityChange = -5 + random.nextFloat() * 10; // -5% to +5%
        float pressureChange = -3 + random.nextFloat() * 6;  // -3hPa to +3hPa

        // Apply changes
        temperature += tempChange;
        humidity += humidityChange;
        pressure += pressureChange;

        // Clamp values to reasonable ranges
        if (humidity < 0) humidity = 0;
        if (humidity > 100) humidity = 100;

        System.out.printf("Weather changed randomly Temp: %.1f°C, Humidity: %.1f%%, Pressure: %.1f hPa%n",
                        temperature, humidity, pressure);

        // Notify observers of the update
        notifyObservers();
    }


    @Override
    public void registerObserver(WeatherObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(WeatherObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
    
}
