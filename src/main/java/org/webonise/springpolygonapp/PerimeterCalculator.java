package org.webonise.springpolygonapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Component
@Lazy
public class PerimeterCalculator implements PolygonCalculator {
    private static Logger LOGGER = Logger.getLogger(PerimeterCalculator.class.getName());
    private int noOfSides;
    private double sideLength;
    private double perimeter;
    @Autowired
    private LoggerManager loggerManager;

    @PostConstruct
    void init() {
        LOGGER = loggerManager.getLOGGER(LOGGER);
        this.noOfSides = Application.noOfSides;
        this.sideLength = Application.sideLength;
    }

    @Override
    public void calculator() {
        perimeter = noOfSides * sideLength;
    }

    @Override
    public void printResult() {
        LOGGER.info("Perimeter :" + perimeter);
    }
}
