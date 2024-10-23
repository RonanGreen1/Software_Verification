package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;


public class Rate {
    private final CarParkKind kind;
    private final BigDecimal hourlyNormalRate;
    private final BigDecimal hourlyReducedRate;
    private final ArrayList<Period> reducedPeriods;
    private final ArrayList<Period> normalPeriods;

    public Rate(CarParkKind kind, ArrayList<Period> reducedPeriods, ArrayList<Period> normalPeriods, BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate) {
        if (hourlyNormalRate.compareTo(BigDecimal.ZERO) < 0 ||
                hourlyNormalRate.compareTo(BigDecimal.TEN) > 0 ||
                hourlyReducedRate.compareTo(BigDecimal.ZERO) < 0 ||
                hourlyReducedRate.compareTo(BigDecimal.TEN) > 0 ||
                hourlyNormalRate.compareTo(hourlyReducedRate) < 0) {
            throw new IllegalArgumentException("Hourly rates must be within valid ranges and normal rate must be greater than or equal to reduced rate");
        }

        this.kind = kind;
        this.reducedPeriods = reducedPeriods;
        this.normalPeriods = normalPeriods;
        this.hourlyNormalRate = hourlyNormalRate;
        this.hourlyReducedRate = hourlyReducedRate;

    }

    // Other methods can be added here
}

enum CarParkKind {
    STAFF, STUDENT, VISITOR, MANAGEMENT
}
