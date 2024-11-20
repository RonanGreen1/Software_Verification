package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GreenRonanRateTest2 {

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
    public void test_13_InvalidHourlyNormalRateLowerBoundary() {
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
    public void test_14_InvalidHourlyReducedRateLowerBoundary() {
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
    public void test_15_InvalidHourlyNormalRateLowerThanHourlyReducedRate() {
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
    void test_16_InvalidNormalPeriodNull() {
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
    void test_17_InvalidReducedPeriodNull() {
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
    void test_18_InvalidHourlyNormalRateNull() {
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
    void test_19_InvalidHourlyReducedRateNull() {
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
    void test_20_InvalidReducedPeriods() {
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
    void test_21_InvalidNormalPeriods() {
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
    void test_22_InvalidReducedAndNormalPeriodsOverlap() {
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
    void test_23_InvalidNormalPeriodsIndividualValidity() {
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
    void test_24_InvalidReducedPeriodsIndividualValidity() {
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
    void test_25_InvalidPeriodsIsValidFalseInLoop() {
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
    public void test_26_ValidPeriodStayInsideHourlyNormalRate() {
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
    public void test_27_ValidPeriodStayInsideHourlyReducedRate() {
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
    public void test_28_ValidPeriodStayStartInsideHourlyReducedRateAndEndInsideHourlyNormalRate() {
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
    public void test_29_ValidPeriodStayStartInsideHourlyNormalRateAndEndInsideHourlyReducedRate() {
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
    public void test_30_InvalidWithNullValueForPeriodStay() {
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
    void test_31_ValidVisitorKindCalculation() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(10, 12);
        BigDecimal expectedCost = BigDecimal.ZERO;

        assertEquals(expectedCost, rate.calculate(periodStay));
    }
}