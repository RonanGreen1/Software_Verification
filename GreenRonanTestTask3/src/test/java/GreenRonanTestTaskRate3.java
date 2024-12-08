package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GreenRonanTestTaskRate3 {

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
    void testVisitorKindCalculation() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        // Total cost = 15.00 (10.00 free, 50% of 5.00 = 2.50)
        Period periodStay = new Period(10, 13); // 3 normal hours = 15.00
        BigDecimal expectedCost = new BigDecimal("2.5");

        assertEquals(expectedCost, rate.calculate(periodStay));
    }

    @Test
    void testManagementKindCalculation() {
        CarParkKind kind = CarParkKind.MANAGEMENT;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("3");
        BigDecimal hourlyReducedRate = new BigDecimal("1");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        // Total cost = 3.00 (below minimum, so it should be 4.00)
        Period periodStay = new Period(10, 11); // 1 normal hour = 3.00
        BigDecimal expectedCost = new BigDecimal("4.0");

        assertEquals(expectedCost, rate.calculate(periodStay));
    }

    @Test
    void testStudentKindCalculation() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        // Total cost = 15.00 (5.50 full, 25% reduction on 9.50 = 7.13 + 5.50 = 12.63)
        Period periodStay = new Period(10, 13); // 3 normal hours = 15.00
        BigDecimal expectedCost = new BigDecimal("12.63");

        assertEquals(expectedCost.setScale(2, RoundingMode.HALF_UP), rate.calculate(periodStay).setScale(2, RoundingMode.HALF_UP)); // Used to round up 1 decimal place
    }

    @Test
    void testStaffKindCalculation() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 17));

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(17, 24));

        BigDecimal hourlyNormalRate = new BigDecimal("5");
        BigDecimal hourlyReducedRate = new BigDecimal("2");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, hourlyNormalRate, hourlyReducedRate);

        // Total cost = 20.00 (but capped at 16.00)
        Period periodStay = new Period(10, 14); // 4 normal hours = 20.00
        BigDecimal expectedCost = new BigDecimal("16.0");

        assertEquals(expectedCost, rate.calculate(periodStay));
    }



}