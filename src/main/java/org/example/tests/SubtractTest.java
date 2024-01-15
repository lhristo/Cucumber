package org.example.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractTest {
    @DataProvider(name = "subtractTestData")
    public Object[][] subtractionTestData() {
        return new Object[][] {
                { 9, 3, 6 },
                { 6, 3, 3 },
                { 3, 3, 0 },
                { 3, 2, 2 },
                { 4, 2, 1 },
        };
    }
    @Test(dataProvider = "subtractTestData", groups = {"subtraction"})
    public void testSubtraction(int a, int b, int expectedResult) {
        Subtraction subtract = new Subtraction();
        int result = subtract.subtract(a, b);
        assertEquals(result, expectedResult);
    }
}
