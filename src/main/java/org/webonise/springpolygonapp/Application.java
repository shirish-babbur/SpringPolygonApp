package org.webonise.springpolygonapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.logging.Logger;

@Component("Application")
public class Application {
    private static Logger LOGGER = Logger.getLogger(Application.class.getName());
    private static final int UPPERBOUND = 3;
    private static final int LOWERBOUND = 8;
    public static int noOfSides;
    public static double sideLength;
    @Autowired
    private Scanner input;
    @Autowired
    private LoggerManager loggerManager;
    @Autowired
    @Lazy
    private PolygonCalculator internalAngleCaculator;
    @Autowired
    @Lazy
    private PolygonCalculator perimeterCalculator;

    public void startApplication() {
        LOGGER = loggerManager.getLOGGER(LOGGER);
        LOGGER.info("Enter No of Sides and Length of Side");
        noOfSides = input.nextInt();
        sideLength = input.nextDouble();
        if (validateSides(noOfSides)) {
            internalAngleCaculator.calculator();
            internalAngleCaculator.printResult();
            perimeterCalculator.calculator();
            perimeterCalculator.printResult();
        } else {
            LOGGER.info("No of Sides must be between 3 and 8.");
        }
    }

    private boolean validateSides(int noOfSides) {
        if (noOfSides < UPPERBOUND) return false;
        if (noOfSides > LOWERBOUND) return false;
        return true;
    }
}