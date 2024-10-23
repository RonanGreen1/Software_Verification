package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RateTest {

    @Test
    public void testValidKind() {
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(6, 8));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        // Creating a valid Rate object with valid kind should not throw an exception
        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void testCalculateNormalPeriod() {
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(10, 12);
        BigDecimal expectedCost = new BigDecimal("10.00");

        assertEquals(expectedCost, rate.calculate(periodStay));
    }
}