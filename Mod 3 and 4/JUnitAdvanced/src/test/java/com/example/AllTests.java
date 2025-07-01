package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    EvenCheckerTest.class,
    OrderedTests.class,
    ExceptionThrowerTest.class
})
public class AllTests {
    // This class is just a holder for the suite
}
