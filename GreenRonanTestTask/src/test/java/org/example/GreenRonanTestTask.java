package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreenRonanTestTask {
    @Test
    void validHoursForPeriod() {
        Period period1 = new Period(8, 10);
        Period period2 = new Period(17, 24);
        assertEquals(2, period1.getDuration());
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
        assertFalse(period1.overlapsWith(period2));
    }

    @Test
    void validOverlap() {
        Period period1 = new Period(3, 18);
        Period period2 = new Period(17, 24);
        assertEquals(15, period1.getDuration());
        assertTrue(period1.overlapsWith(period2));
    }

    @Test
    void invalidParkingHoursStartLowerThanEnd() {
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
}