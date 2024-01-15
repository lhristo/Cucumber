package org.example.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTest {
    @DataProvider(name = "divisionTestData")
    public Object[][] divisionTestData() {
        return new Object[][] {
                { 9, 3, 3 },
                { 6, 3, 2 },
                { 3, 3, 1 },
                { 3, 3, 8 },
                { 4, 2, 1 },
        };
    }
    @Test(dataProvider = "divisionTestData", groups = {"division"})
    public void testDivide(int a, int b, int expectedResult) {
        Division division = new Division();
        int result = division.divide(a, b);
        assertEquals(result, expectedResult);
    }
}

