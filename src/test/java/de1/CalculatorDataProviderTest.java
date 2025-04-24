package de1;

import com.course.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//
public class CalculatorDataProviderTest {

    Calculator calculator = new Calculator();

    @DataProvider(name = "addData")
    public Object[][] addTestData() {
        return new Object[][]{
                {3, 5, 8},
                {4, 2, 6}
        };
    }

    @DataProvider(name = "subData")
    public Object[][] subtractTestData() {
        return new Object[][]{
                {9, 4, 5},
                {7, 2, 5}
        };
    }

    @Test(priority = 1)
    public void testMultiply() {
        Assert.assertEquals(calculator.multiply(2, 3), 6);
    }

    @Test(dataProvider = "addData", priority = 2)
    public void testAdd(int a, int b, int expected) {
        Assert.assertEquals(calculator.add(a, b), expected);
    }

    @Test(dataProvider = "subData", priority = 5)
    public void testSubtract(int a, int b, int expected) {
        Assert.assertEquals(calculator.subtract(a, b), expected);
    }

    @Test(priority = 3)
    public void testDivide() {
        Assert.assertEquals(calculator.divide(8, 2), 4.0f);
    }

    @Test(priority = 4, expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(5, 0);
    }
}
