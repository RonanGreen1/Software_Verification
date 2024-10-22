package org.example;

import java.math.BigDecimal;



public class Rate {
    private final CarParkKind kind;
    private final BigDecimal hourlyNormalRate;
    private final BigDecimal hourlyReducedRate;

    Public Rate(CarParkKind Kind, BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate){
        if (hourlyNormalRate.compareTo(BigDecimal.ZERO) < 0 || 
            hourlyNormalRate.compareTo(BigDecimal.TEN) > 0 || 
            hourlyReducedRate.compareTo(BigDecimal.ZERO) < 0 || 
            hourlyReducedRate.compareTo(BigDecimal.TEN) > 0 || 
            hourlyNormalRate.compareTo(hourlyReducedRate) < 0) {
            throw new IllegalArgumentException("Hourly rates must be within valid ranges and normal rate must be greater than or equal to reduced rate");
        }
        
    }

}

enum CarParkKind {
    STAFF, STUDENT, VISITOR, MANAGEMENT
}
