package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class GreenRonanTestTaskPeriod3 {

    @Test
    void test_1_ValidHoursForPeriod1() {
        Period period1 = new Period(8, 10);
        Period period2 = new Period(17, 24);

        assertEquals(2, period1.duration());
        assertFalse(period1.overlaps(period2));


    }

    @Test
    void test_2_ValidLowerBoundaryForStartAndEndHours() {
        Period period1 = new Period(0, 1);
        Period period2 = new Period(17, 24);

        assertEquals(1, period1.duration());
        assertFalse(period1.overlaps(period2));

    }

    @Test
    void test_3_ValidUpperBoundaryForStartAndEndHours() {
        Period period1 = new Period(23, 24);
        Period period2 = new Period(17, 24);

        assertEquals(1, period1.duration());
        assertTrue(period1.overlaps(period2));

    }

    @Test
    void test_4_InvalidParkingHoursEndLowerThanStart() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Period(10, 8);
        });


    }

    @Test
    void test_5_InvalidHoursOutOfRange() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Period(25, 26);
        });

    }

    @Test
    void test_6_InvalidParkingHoursStartAndEndAreTheSame() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Period(10, 10);
        });

    }

    @Test
    void test_7_InvalidNegativeStartTime() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Period(-1, 5);
        });

    }

    @Test
    void test_8_InvalidNegativeEndTime() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Period(5, -1);
        });

    }

    @Test
    void test_9_InvalidEndTimeAboveTwentyFour() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Period(5, 25); // End is greater than 24
        });
    }

    @Test
    void test_10_ValidPeriodDuration() {
        Period period1 = new Period(2, 10);

        assertEquals(8, period1.duration());


    }

    @Test
    void test_12_ValidMinimumBoundary() {
        Period period1 = new Period(0, 1);

        assertEquals(1, period1.duration());

    }

    @Test
    void test_12_ValidMaximumBoundary() {
        Period period1 = new Period(0, 24);

        assertEquals(24, period1.duration());


    }

    @Test
    void test_13_ValidNoOverlap() {
        Period period1 = new Period(8, 11);
        Period period2 = new Period(17, 24);

        assertEquals(3, period1.duration());
        assertFalse(period1.overlaps(period2));

    }

    @Test
    void test_14_ValidOverlap() {
        Period period1 = new Period(3, 18);
        Period period2 = new Period(17, 24);

        assertEquals(15, period1.duration());
        assertTrue(period1.overlaps(period2));

    }

    @Test
    void test_15_ValidNoOverlapWithBoundariesTouching() {
        Period period1 = new Period(5, 10);
        Period period2 = new Period(10, 15);

        assertEquals(5, period1.duration());
        assertFalse(period1.overlaps(period2));

    }

    @Test
    void test_16_ValidFullOverlap() {
        Period period1 = new Period(4, 15);
        Period period2 = new Period(6, 10);

        assertEquals(11, period1.duration());
        assertTrue(period1.overlaps(period2));

    }

    @Test
    void test_17_ValidIsInBecomesFalseInLoop() {
        Period period1 = new Period(5, 10); // The main period being checked
        List<Period> periodList = new ArrayList<>();
        periodList.add(new Period(3, 6));  // Does not match
        periodList.add(new Period(5, 10)); // Matches period1 exactly, causing !isIn to become false
        periodList.add(new Period(10, 15)); // Does not match

        // Check the occurrences of period1 in periodList
        int occurrences = period1.occurences(periodList);

        // Assert that the occurrence is 5 (all hours from 5-10 are matched)
        assertEquals(5, occurrences);
    }

}