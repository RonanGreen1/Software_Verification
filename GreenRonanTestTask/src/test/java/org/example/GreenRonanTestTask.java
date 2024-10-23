package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class GreenRonanTestTask {
    @Test
    void validHoursForPeriod() {
        Period period1 = new Period(8, 10);
        Period period2 = new Period(17, 24);
        assertEquals(2, period1.getDuration());
        assertFalse(period1.overlapsWith(period2));
    }

    @Test
    void validLowerBoundaryForStartAndEndHours() {
        Period period1 = new Period(0, 1);
        Period period2 = new Period(17, 24);
        assertEquals(1, period1.getDuration());
        assertFalse(period1.overlapsWith(period2));
    }

    @Test
    void validUpperBoundaryForStartAndEndHours() {
        Period period1 = new Period(23, 24);
        Period period2 = new Period(17, 24);
        assertEquals(1, period1.getDuration());
        assertTrue(period1.overlapsWith(period2));
    }

    @Test
    void invalidParkingHoursEndLowerThanStart() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Period(10, 8);
        });
    }

    @Test
    void invalidHoursOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Period(25, 26);
        });
    }

    @Test
    void invalidParkingHoursStartAndEndAreTheSame() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Period(10, 10);
        });
    }

    @Test
    void invalidNegativeStartTime() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Period(-1, 5);
        });
    }

    @Test
    void invalidNegativeEndTime() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Period(5, -1);
        });
    }

    @Test
    void validNoOverlap() {
        Period period1 = new Period(8, 11);
        Period period2 = new Period(17, 24);
        assertEquals(3, period1.getDuration());
        assertFalse(period1.overlapsWith(period2));
    }

    @Test
    void validNoOverlap() {
        Period period1 = new Period(8, 11);
        Period period2 = new Period(17, 24);
        assertEquals(3, period1.getDuration());
        assertFalse(period1.overlapsWith(period2));
    }

    @Test
    void validOverlap() {
        Period period1 = new Period(3, 18);
        Period period2 = new Period(17, 24);
        assertEquals(15, period1.getDuration());
        assertTrue(period1.overlapsWith(period2));
    }
}