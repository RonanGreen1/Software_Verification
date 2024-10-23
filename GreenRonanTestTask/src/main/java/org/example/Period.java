package org.example;

public class Period {
    final int start;
    final int end;

    public Period(int start, int end) {
        if (start >= end || start < 0 || end > 24) {
            throw new IllegalArgumentException("Invalid period hours");
        }
        this.start = start;
        this.end = end;
    }

    public int getDuration() {
        return end - start;
    }

    public boolean overlapsWith(Period period) {
        return this.start < period.end && period.start < this.end;
    }
}
