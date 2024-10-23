package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RateTest {

    @Test
    public void validKind() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void validHourlyNormalRate() {
        CarParkKind kind = CarParkKind.MANAGEMENT;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void validHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("7");
        BigDecimal hourlyReducedRate = new BigDecimal("3");

        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void validHourlyNormalRateLowerBoundaries() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("0");
        BigDecimal hourlyReducedRate = new BigDecimal("0");

        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void validHourlyNormalRateUpperBoundaries() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("10");
        BigDecimal hourlyReducedRate = new BigDecimal("5");

        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void validHourlyReducedRateLowerBoundaries() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("0");

        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void validHourlyReducedRateUpperBoundaries() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("10");
        BigDecimal hourlyReducedRate = new BigDecimal("10");

        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void validHourlyNormalRateHigherThanHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("6");
        BigDecimal hourlyReducedRate = new BigDecimal("3");

        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void validHourlyNormalRateEqualToHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("5");

        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void validHourlyNormalRateAndHourlyReducedRateBoth0() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("0");
        BigDecimal hourlyReducedRate = new BigDecimal("0");

        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void validHourlyNormalRateAndHourlyReducedRateBoth10() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("10");
        BigDecimal hourlyReducedRate = new BigDecimal("10");

        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void invalidKind() {
        String kind = "EMPLOYEE";
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.valueOf(kind), reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void invalidHourlyNormalRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("15");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void invalidHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("15");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void invalidHourlyNormalRateUpperBoundary() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("11");
        BigDecimal hourlyReducedRate = new BigDecimal("5");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void invalidHourlyNormalRateLowerBoundary() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("-1");
        BigDecimal hourlyReducedRate = new BigDecimal("5");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void invalidHourlyReducedRateUpperBoundary() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("11");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void invalidHourlyReducedRateLowerBoundary() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("-1");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void invalidHourlyNormalRateLowerThanHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("8");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    public void validPeriodStayInsideHourlyNormalRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(10, 12);
        BigDecimal expectedCost = new BigDecimal("10.00");

        assertEquals(expectedCost, rate.calculate(periodStay));
    }

    @Test
    public void validPeriodStayInsideHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(18, 20);
        BigDecimal expectedCost = new BigDecimal("4.00");

        assertEquals(expectedCost, rate.calculate(periodStay));
    }

    @Test
    public void validPeriodStayStartInsideHourlyReducedRateAndEndInsideHourlyNormalRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(3, 7));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(6, 8);
        BigDecimal expectedCost = new BigDecimal("7.00");

        assertEquals(expectedCost, rate.calculate(periodStay));
    }

    @Test
    public void validPeriodStayStartInsideHourlyNormalRateAndEndInsideHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(16, 18);
        BigDecimal expectedCost = new BigDecimal("7.00");

        assertEquals(expectedCost, rate.calculate(periodStay));
    }
}