package ru.almyal;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.*;

public class Main {
    private static final String TEMPERATURE = "temperature";
    private static final String AIR_HUMIDITY = "airHumidity";
    private static final String WATER_CHANGE_FREQ = "waterChangeFrequency";
    private static final String SUNLIGHT_BRIGHTNESS = "sunlightBrightness";

    public static void main(String[] args) {
//        String fileName = "./src/main/resources/bellFunc.fcl"; // to create bell functions fcl file
//        String fileName = "./src/main/resources/SZGauss.fcl"; // to create gauss and S/Z functions fcl file
        String fileName = "./src/main/resources/pieceLinear.fcl";
        // Load from 'FCL' file
        FIS fis = FIS.load(fileName,true);
        if( fis == null ) {         // Error while loading
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }
        // Show membership functions for terms
        JFuzzyChart.get().chart(fis);

        // Set inputs
        fis.setVariable(TEMPERATURE, 23);
        fis.setVariable(AIR_HUMIDITY, 70);
        fis.setVariable(WATER_CHANGE_FREQ, 7);
        fis.setVariable(SUNLIGHT_BRIGHTNESS, 6);

//        fis.setVariable(TEMPERATURE, 10);
//        fis.setVariable(AIR_HUMIDITY, 0);
//        fis.setVariable(WATER_CHANGE_FREQ, 0);
//        fis.setVariable(SUNLIGHT_BRIGHTNESS, 0);
//
//        fis.setVariable(TEMPERATURE, 10);
//        fis.setVariable(AIR_HUMIDITY, 60);
//        fis.setVariable(WATER_CHANGE_FREQ, 7);
//        fis.setVariable(SUNLIGHT_BRIGHTNESS, 10);
//
//        fis.setVariable(TEMPERATURE, 9);
//        fis.setVariable(AIR_HUMIDITY, 80);
//        fis.setVariable(WATER_CHANGE_FREQ, 5);
//        fis.setVariable(SUNLIGHT_BRIGHTNESS, 6);
//
//        fis.setVariable(TEMPERATURE, 5);
//        fis.setVariable(AIR_HUMIDITY, 65);
//        fis.setVariable(WATER_CHANGE_FREQ, 2);
//        fis.setVariable(SUNLIGHT_BRIGHTNESS, 5);
//
//        fis.setVariable(TEMPERATURE, 29);
//        fis.setVariable(AIR_HUMIDITY, 20);
//        fis.setVariable(WATER_CHANGE_FREQ, 2);
//        fis.setVariable(SUNLIGHT_BRIGHTNESS, 1);
//
//        fis.setVariable(TEMPERATURE, 0);
//        fis.setVariable(AIR_HUMIDITY, 100);
//        fis.setVariable(WATER_CHANGE_FREQ, 0);
//        fis.setVariable(SUNLIGHT_BRIGHTNESS, 10);
//
//        fis.setVariable(TEMPERATURE, 15);
//        fis.setVariable(AIR_HUMIDITY, 60);
//        fis.setVariable(WATER_CHANGE_FREQ, 7);
//        fis.setVariable(SUNLIGHT_BRIGHTNESS, 6);

//        fis.setVariable(TEMPERATURE, 28);
//        fis.setVariable(AIR_HUMIDITY, 5);
//        fis.setVariable(WATER_CHANGE_FREQ, 3);
//        fis.setVariable(SUNLIGHT_BRIGHTNESS, 9);
//
//        fis.setVariable(TEMPERATURE, 0);
//        fis.setVariable(AIR_HUMIDITY, 50);
//        fis.setVariable(WATER_CHANGE_FREQ, 7);
//        fis.setVariable(SUNLIGHT_BRIGHTNESS, 6);

       // Evaluate
        fis.evaluate();

      // Show output variable's chart
        Variable bouquetFreshnessDuration = fis.getVariable("bouquetFreshnessDuration");
        JFuzzyChart.get().chart(bouquetFreshnessDuration, bouquetFreshnessDuration.getDefuzzifier(), true);
    }
}