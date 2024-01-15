package org.example.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplyTest {
    @DataProvider(name = "multiplicationTestData")
    public Object[][] multiplyTestData() {
        return new Object[][] {
                { 3, 3, 9 },
                { 6, 3, 18 },
                { 3, 3, 10 },
                { 3, 3, 9 },
                { 4, 2, 8 },
        };
    }
    @Test(dataProvider = "multiplicationTestData", groups = {"multiply"})
    public void testDivide(int a, int b, int expectedResult) {
        Multiply multiply = new Multiply();
        int result = multiply.multiply(a, b);
        assertEquals(result, expectedResult);
    }
}
