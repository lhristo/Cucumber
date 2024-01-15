package org.example.tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AddTest {
    @DataProvider(name = "additionTestData")
    public Object[][] additionTestData() {
        return new Object[][] {
                { 2, 3, 5 },
                { 1, 3, 5 },
                { 4, 3, 5 },
                { -1, 1, 0 },
                { 0, 0, 0 }
        };
    }
    @Test(dataProvider = "additionTestData", groups = {"addition"})
    public void testAdd(int a, int b, int expectedResult) {
        Addition addition = new Addition();
        int result = addition.add(a, b);
        assertEquals(result, expectedResult);
    }
}
