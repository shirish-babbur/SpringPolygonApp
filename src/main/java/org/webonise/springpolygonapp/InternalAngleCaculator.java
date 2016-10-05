package org.webonise.springpolygonapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Component
@Lazy
public class InternalAngleCaculator implements PolygonCalculator {
    private static Logger LOGGER = Logger.getLogger(InternalAngleCaculator.class.getName());
    private final static int PIE = 180;
    private int noOfSides;
    private int sumOfAngles;
    @Autowired
    private LoggerManager loggerManager;

    @PostConstruct
    void init() {
        LOGGER = loggerManager.getLOGGER(LOGGER);
        this.noOfSides = Application.noOfSides;
    }

    @Override
    public void calculator() {
        sumOfAngles = PIE * (noOfSides - 2);
    }

    @Override
    public void printResult() {
        LOGGER.info("Sum Of Interior Angles:" + sumOfAngles);
    }
}
