package org.example;

import java.math.BigDecimal;



public class Rate {
    private final CarParkKind kind;
    private final BigDecimal hourlyNormalRate;
    private final BigDecimal hourlyReducedRate;

}

enum CarParkKind {
    STAFF, STUDENT, VISITOR, MANAGEMENT
}
