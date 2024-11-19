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
// 1. Staring Branch Coverage 55%
// Coverage Findings:
// 1. The branch coverage analysis for the Rate class revealed that 58% of the code was covered (21 out of 36 branches).
// 2. Lines 16 (`throw new IllegalArgumentException("periods cannot be null");`) and 19 (`throw new IllegalArgumentException("The rates cannot be null");`) were not accessed.
//    This indicates that no tests are verifying the scenario where null values are passed for periods or rates.
// 3. Line 28 (`throw new IllegalArgumentException("The periods are not valid individually");`) and line 31 (`throw new IllegalArgumentException("The periods overlaps");`) were also not covered.
//    This suggests missing tests for invalid periods, either individually or due to overlaps.
// 4. Lines 65-69 were not covered (`if (list.size() >= 2) { ... }`).
//    This indicates that scenarios involving multiple periods in the list and their validation are not being tested adequately, particularly edge cases involving more than two periods.
// Increasing Coverage:
// 1.  Increased branch coverage up tp 94% by covering the lines that weren't covered in the original tests I made with tests 25-33
// 2. Increased branch coverage up to 100% by exploring the alternatives to while (i < lastIndex && isValid) and if (this.kind == CarParkKind.VISITOR)
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

        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
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


        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(CarParkKind.valueOf(kind), reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertDoesNotThrow(() -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

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


        assertEquals(expectedCost, rate.calculate(periodStay));

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

        assertEquals(expectedCost, rate.calculate(periodStay));

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


        assertEquals(expectedCost, rate.calculate(periodStay));

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


        assertEquals(expectedCost, rate.calculate(periodStay));

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


        assertThrows(NullPointerException.class, () -> {
            rate.calculate(periodStay);
        });

    }

    @Test
    void test_25_InvalidNormalPeriodNull() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = null;


        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    void test_26_InvalidReducedPeriodNull() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(17, 24));

        ArrayList<Period> reducedPeriods = null;


        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    void test_27_InvalidHourlyNormalRateNull() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(17, 24));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));


        BigDecimal hourlyNormalRate = null;
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    void test_28_InvalidHourlyReducedRateNull() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(17, 24));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));


        BigDecimal hourlyNormalRate = new BigDecimal("2");
        BigDecimal hourlyReducedRate = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    void test_29_InvalidReducedPeriods() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(10, 11));
        reducedPeriods.add(new Period(8, 9));

        BigDecimal hourlyNormalRate = new BigDecimal("2");
        BigDecimal hourlyReducedRate = new BigDecimal("1");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    void test_30_InvalidNormalPeriods() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 11));
        normalPeriods.add(new Period(8, 9));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(9, 10));


        BigDecimal hourlyNormalRate = new BigDecimal("2");
        BigDecimal hourlyReducedRate = new BigDecimal("1");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    void test_31_InvalidReducedAndNormalPeriodsOverlap() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 11));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(9, 10));


        BigDecimal hourlyNormalRate = new BigDecimal("2");
        BigDecimal hourlyReducedRate = new BigDecimal("1");

        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });
    }

    @Test
    void test_32_InvalidNormalPeriodsIndividualValidity() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 10));
        normalPeriods.add(new Period(9, 10));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

        assertEquals("The periods are not valid individually", exception.getMessage());
    }

    @Test
    void test_33_InvalidReducedPeriodsIndividualValidity() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 10));


        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

        assertEquals("The periods are not valid individually", exception.getMessage());
    }

    @Test
    void test_34_InvalidPeriodsIsValidFalseInLoop() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 10));
        normalPeriods.add(new Period(10, 11));
        normalPeriods.add(new Period(9, 10));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 20));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);
        });

        assertEquals("The periods are not valid individually", exception.getMessage());
    }

    @Test
    void test_35_ValidVisitorKindCalculation() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 17)); // Valid normal periods

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24)); // Valid reduced periods

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(10, 12); // Staying during normal rate period
        BigDecimal expectedCost = BigDecimal.ZERO; // Visitor kind calculation should always return 0

        assertEquals(expectedCost, rate.calculate(periodStay));
    }
}