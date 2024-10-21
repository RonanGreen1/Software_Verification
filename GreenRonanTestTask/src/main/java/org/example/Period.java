package org.example;

public class Period {
    private final int start;
    private final int end;

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

    public boolean overlapsWith(Period other) {
        return this.start < other.end && other.start < this.end;
    }
}
