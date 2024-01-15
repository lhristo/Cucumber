package org.example.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ModuloTest {
    @DataProvider(name = "moduloTestData")
    public Object[][] moduloTestData() {
        return new Object[][] {
                { 10, 3, 1 },
                { 7, 3, 1 },
                { 12, 5, 2 },
                { 13, 3, 9 },
                { 4, 1, 8 },
        };
    }
    @Test(dataProvider = "moduloTestData", groups = {"modulo"})
    public void testModulo(int a, int b, int expectedResult) {
        Modulo modulo = new Modulo();
        int result = modulo.modulo(a, b);
        assertEquals(result, expectedResult);
    }
}