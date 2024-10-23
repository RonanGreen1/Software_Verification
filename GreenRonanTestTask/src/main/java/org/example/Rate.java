package org.example;

import org.example.Period;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

        if (!isValidCarParkKind(kind)) {
            throw new IllegalArgumentException("Invalid car park kind");
        }

        this.kind = kind;
        this.reducedPeriods = reducedPeriods;
        this.normalPeriods = normalPeriods;
        this.hourlyNormalRate = hourlyNormalRate;
        this.hourlyReducedRate = hourlyReducedRate;

    }

    private boolean isValidCarParkKind(CarParkKind kind) {
        return kind == CarParkKind.STAFF || kind == CarParkKind.STUDENT || kind == CarParkKind.VISITOR || kind == CarParkKind.MANAGEMENT;
    }

    public BigDecimal calculate(Period periodStay) {
        BigDecimal totalCost = BigDecimal.ZERO;

        int start = periodStay.start;
        int end = periodStay.end;

        for (int hour = start; hour < end; hour++) {
            boolean isNormal = false;
            boolean isReduced = false;

            for (Period normalPeriod : normalPeriods) {
                if (hour >= normalPeriod.start && hour < normalPeriod.end) {
                    isNormal = true;
                    break;
                }
            }

            for (Period reducedPeriod : reducedPeriods) {
                if (hour >= reducedPeriod.start && hour < reducedPeriod.end) {
                    isReduced = true;
                    break;
                }
            }

            if (isNormal) {
                totalCost = totalCost.add(hourlyNormalRate);
            } else if (isReduced) {
                totalCost = totalCost.add(hourlyReducedRate);
            }
            // If neither normal nor reduced, the hour is free.
        }

        totalCost = totalCost.setScale(2, RoundingMode.HALF_UP);
        return totalCost;
    }

    // Other methods can be added here
}

enum CarParkKind {
    STAFF, STUDENT, VISITOR, MANAGEMENT
}
