package org.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({GreenRonanRateTest.class, GreenRonanPeriodTest.class})
public class GreenRonanTestTask1{
}

