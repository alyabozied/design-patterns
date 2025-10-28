package com.abozied.Observer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WeatherTimeGraphSwing extends JFrame implements WeatherObserver {
    private XYSeries temperatureSeries;
    private int time = 0;

    public WeatherTimeGraphSwing() {
        super("Real-Time Temperature Chart");

        // Create dataset
        temperatureSeries = new XYSeries("Temperature");
        XYSeriesCollection dataset = new XYSeriesCollection(temperatureSeries);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Live Temperature Data",
                "Time (s)",
                "Temperature (°C)",
                dataset
        );

        // Customize chart appearance
        XYPlot plot = chart.getXYPlot();
        plot.getDomainAxis().setAutoRange(true);
        plot.getRangeAxis().setRange(0, 50);

        // Add chart to panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        SwingUtilities.invokeLater(() -> {
            temperatureSeries.add(time++, temperature);
            if (temperatureSeries.getItemCount() > 30) {
                temperatureSeries.remove(0); // keep last 30 points
            }
        });
    }
}
