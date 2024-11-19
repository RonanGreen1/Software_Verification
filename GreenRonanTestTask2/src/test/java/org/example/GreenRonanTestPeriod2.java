package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

// Changes Made:
// Initial changes to run test:
// 1. Method Name Adjustments:
//    - Updated method names from getDuration() to duration() and overlapsWith() to overlaps() to match the current Period class.
// 2. Assertion Updates:
//    - Updated assertions accordingly to use the correct methods and maintain the original intent of each test.
// Coverage:
// 1. Staring Branch Coverage 88%
// Coverage Findings:
// 1. The branch coverage analysis for the Period class revealed that 88% of the code was covered (23 out of 26 branches).
// 2. Specifically, line 26 (`return hour >= this.startHour && hour < this.endHour;`) was not covered (0 out of 4 branches).
//    This suggests that certain conditions involving `hour` being within the period boundaries are not being tested adequately.
// 3. Line 63 (`return this.endHour > period.startHour && this.startHour < period.endHour;`) also had 0 out of 2 branches covered.
//    This indicates that scenarios involving overlapping periods are missing or not sufficiently tested, particularly edge cases where periods touch or partially overlap.

class GreenRonanTestTaskPeriod2 {

    private static final Logger logger = Logger.getLogger("PeriodLogger");

    @Test
    void test_1_ValidHoursForPeriod1() {
        Period period1 = new Period(8, 10);
        Period period2 = new Period(17, 24);
        try {
            assertEquals(2, period1.duration());
            assertFalse(period1.overlaps(period2));
            logger.info("Test 1 passed");
        } catch (AssertionError e) {
            logger.severe("Test 1 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_2_ValidLowerBoundaryForStartAndEndHours() {
        Period period1 = new Period(0, 1);
        Period period2 = new Period(17, 24);
        try {
            assertEquals(1, period1.duration());
            assertFalse(period1.overlaps(period2));
            logger.info("Test 2 passed");
        } catch (AssertionError e) {
            logger.severe("Test 2 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_3_ValidUpperBoundaryForStartAndEndHours() {
        Period period1 = new Period(23, 24);
        Period period2 = new Period(17, 24);
        try {
            assertEquals(1, period1.duration());
            assertTrue(period1.overlaps(period2));
            logger.info("Test 3 passed");
        } catch (AssertionError e) {
            logger.severe("Test 3 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_4_InvalidParkingHoursEndLowerThanStart() {
        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Period(10, 8);
            });
            logger.info("Test 4 passed");
        } catch (AssertionError e) {
            logger.severe("Test 4 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_5_InvalidHoursOutOfRange() {
        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Period(25, 26);
            });
            logger.info("Test 5 passed");
        } catch (AssertionError e) {
            logger.severe("Test 5 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_6_InvalidParkingHoursStartAndEndAreTheSame() {
        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Period(10, 10);
            });
            logger.info("Test 6 passed");
        } catch (AssertionError e) {
            logger.severe("Test 6 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_7_InvalidNegativeStartTime() {
        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Period(-1, 5);
            });
            logger.info("Test 7 passed");
        } catch (AssertionError e) {
            logger.severe("Test 7 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_8_InvalidNegativeEndTime() {
        try {
            assertThrows(IllegalArgumentException.class, () -> {
                new Period(5, -1);
            });
            logger.info("Test 8 passed");
        } catch (AssertionError e) {
            logger.severe("Test 8 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_9_ValidPeriodDuration() {
        Period period1 = new Period(2, 10);
        try {
            assertEquals(8, period1.duration());
            logger.info("Test 9 passed");
        } catch (AssertionError e) {
            logger.severe("Test 9 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_10_ValidMinimumBoundary() {
        Period period1 = new Period(0, 1);
        try {
            assertEquals(1, period1.duration());
            logger.info("Test 10 passed");
        } catch (AssertionError e) {
            logger.severe("Test 10 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_11_ValidMaximumBoundary() {
        Period period1 = new Period(0, 24);
        try {
            assertEquals(24, period1.duration());
            logger.info("Test 11 passed");
        } catch (AssertionError e) {
            logger.severe("Test 11 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_12_ValidNoOverlap() {
        Period period1 = new Period(8, 11);
        Period period2 = new Period(17, 24);
        try {
            assertEquals(3, period1.duration());
            assertFalse(period1.overlaps(period2));
            logger.info("Test 12 passed");
        } catch (AssertionError e) {
            logger.severe("Test 12 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_13_ValidOverlap() {
        Period period1 = new Period(3, 18);
        Period period2 = new Period(17, 24);
        try {
            assertEquals(15, period1.duration());
            assertTrue(period1.overlaps(period2));
            logger.info("Test 13 passed");
        } catch (AssertionError e) {
            logger.severe("Test 13 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_14_ValidNoOverlapWithBoundariesTouching() {
        Period period1 = new Period(5, 10);
        Period period2 = new Period(10, 15);
        try {
            assertEquals(5, period1.duration());
            assertFalse(period1.overlaps(period2));
            logger.info("Test 14 passed");
        } catch (AssertionError e) {
            logger.severe("Test 14 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void test_15_ValidFullOverlap() {
        Period period1 = new Period(4, 15);
        Period period2 = new Period(6, 10);
        try {
            assertEquals(11, period1.duration());
            assertTrue(period1.overlaps(period2));
            logger.info("Test 15 passed");
        } catch (AssertionError e) {
            logger.severe("Test 15 failed: " + e.getMessage());
            throw e;
        }
    }

}