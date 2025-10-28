package com.abozied.Observer;

public class ObserverPattern {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        WeatherLogger logger = new WeatherLogger();
        
        WeatherTimeGraphSwing graph = new WeatherTimeGraphSwing();
        weatherData.registerObserver(graph);


        // Wait for JavaFX app to initialize (optional: add synchronization)
        try {
            Thread.sleep(2000); // give time for chart to start
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherData.registerObserver(logger);
        for(int i=0;i< 100;i++){
            try {
                Thread.sleep(1000); // pause for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            weatherData.simulateRandomWeatherChange();
        }
        
    }
}
