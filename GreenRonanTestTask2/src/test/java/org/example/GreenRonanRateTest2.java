package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

// Changes:
// Initial changes to run test:
// 1. No changes made
// Changes for incorrect tests:
// 1. Test 4 BigDecimal hourlyNormalRate needed to be changed from 0 to 1
// 2. Test 7 BigDecimal hourlyNormalRate needed to be changed from 10 to 11
// 3. Test 9, 10, 11 changed to Invalid
// 4. Test 13, 15 changed to valid
// 5. Test 20-23 changed numerical values
// Coverage:
// 1. Staring Coverage 100% Methods, Lines 80%
public class GreenRonanRateTest2 {

    private static final Logger logger = Logger.getLogger("PeriodLogger");

    @Test
    void test_1_ValidKind() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        try {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            logger.info("Test 1 passed");
        } catch (IllegalArgumentException e) {
            logger.severe("Test 1 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_2_ValidHourlyNormalRate() {
        CarParkKind kind = CarParkKind.MANAGEMENT;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        try {
            assertDoesNotThrow(() -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 2 passed");
        } catch (AssertionError e) {
            logger.severe("Test 2 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_3_ValidHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("7");
        BigDecimal hourlyReducedRate = new BigDecimal("3");

        try {
            assertDoesNotThrow(() -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 3 passed");
        } catch (AssertionError e) {
            logger.severe("Test 3 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_4_ValidHourlyNormalRateLowerBoundaries() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("1");
        BigDecimal hourlyReducedRate = new BigDecimal("0");

        try {
            assertDoesNotThrow(() -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 4 passed");
        } catch (AssertionError e) {
            logger.severe("Test 4 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_5_ValidHourlyNormalRateUpperBoundaries() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("10");
        BigDecimal hourlyReducedRate = new BigDecimal("5");

        try {
            assertDoesNotThrow(() -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 5 passed");
        } catch (AssertionError e) {
            logger.severe("Test 5 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_6_ValidHourlyReducedRateLowerBoundaries() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("0");

        try {
            assertDoesNotThrow(() -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 6 passed");
        } catch (AssertionError e) {
            logger.severe("Test 6 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_7_ValidHourlyReducedRateUpperBoundaries() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("11");
        BigDecimal hourlyReducedRate = new BigDecimal("10");

        try {
            assertDoesNotThrow(() -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 7 passed");
        } catch (AssertionError e) {
            logger.severe("Test 7 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_8_ValidHourlyNormalRateHigherThanHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("6");
        BigDecimal hourlyReducedRate = new BigDecimal("3");

        try {
            assertDoesNotThrow(() -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 8 passed");
        } catch (AssertionError e) {
            logger.severe("Test 8 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_9_InvalidNormalRateEqualToReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("5");

        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 9 passed");
        } catch (AssertionError e) {
            logger.severe("Test 9 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_10_InvalidNormalRateAndReducedRateBothZero() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("0");
        BigDecimal hourlyReducedRate = new BigDecimal("0");

        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 10 passed");
        } catch (AssertionError e) {
            logger.severe("Test 10 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_11_InvalidNormalRateAndReducedRateBothTen() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("10");
        BigDecimal hourlyReducedRate = new BigDecimal("10");

        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 11 passed");
        } catch (AssertionError e) {
            logger.severe("Test 11 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_12_InvalidKind() {
        String kind = "EMPLOYEE";
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Rate(CarParkKind.valueOf(kind), reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 12 passed");
        } catch (AssertionError e) {
            logger.severe("Test 12 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_13_ValidHourlyNormalRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("15");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        try {
            assertDoesNotThrow(() -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 13 passed");
        } catch (AssertionError e) {
            logger.severe("Test 13 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_14_InvalidHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("15");

        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 14 passed");
        } catch (AssertionError e) {
            logger.severe("Test 14 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_15_ValidHourlyNormalRateUpperBoundary() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("11");
        BigDecimal hourlyReducedRate = new BigDecimal("5");

        try {
            assertDoesNotThrow(() -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 15 passed");
        } catch (AssertionError e) {
            logger.severe("Test 15 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_16_InvalidHourlyNormalRateLowerBoundary() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("-1");
        BigDecimal hourlyReducedRate = new BigDecimal("5");

        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 16 passed");
        } catch (AssertionError e) {
            logger.severe("Test 16 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_17_InvalidHourlyReducedRateUpperBoundary() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("11");

        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 17 passed");
        } catch (AssertionError e) {
            logger.severe("Test 17 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_18_InvalidHourlyReducedRateLowerBoundary() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("-1");

        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 18 passed");
        } catch (AssertionError e) {
            logger.severe("Test 18 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_19_InvalidHourlyNormalRateLowerThanHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("8");

        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
            });
            logger.info("Test 19 passed");
        } catch (AssertionError e) {
            logger.severe("Test 19 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_20_ValidPeriodStayInsideHourlyNormalRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 12));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(10, 12);
        BigDecimal expectedCost = new BigDecimal("10");

        try {
            assertEquals(expectedCost, rate.calculate(periodStay));
            logger.info("Test 20 passed");
        } catch (AssertionError e) {
            logger.severe("Test 20 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_21_ValidPeriodStayInsideHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(18, 20);
        BigDecimal expectedCost = new BigDecimal("4");

        try {
            assertEquals(expectedCost, rate.calculate(periodStay));
            logger.info("Test 21 passed");
        } catch (AssertionError e) {
            logger.severe("Test 21 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_22_ValidPeriodStayStartInsideHourlyReducedRateAndEndInsideHourlyNormalRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(3, 7));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(6, 8);
        BigDecimal expectedCost = new BigDecimal("7");

        try {
            assertEquals(expectedCost, rate.calculate(periodStay));
            logger.info("Test 22 passed");
        } catch (AssertionError e) {
            logger.severe("Test 22 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_23_ValidPeriodStayStartInsideHourlyNormalRateAndEndInsideHourlyReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(16, 18);
        BigDecimal expectedCost = new BigDecimal("7");

        try {
            assertEquals(expectedCost, rate.calculate(periodStay));
            logger.info("Test 23 passed");
        } catch (AssertionError e) {
            logger.severe("Test 23 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void test_24_InvalidWithNullValueForPeriodStay() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = null;

        try {
            assertThrows(NullPointerException.class, () -> {
                rate.calculate(periodStay);
            });
            logger.info("Test 24 passed");
        } catch (AssertionError e) {
            logger.severe("Test 24 failed: " + e.getMessage());
            throw e;
        }
    }
}