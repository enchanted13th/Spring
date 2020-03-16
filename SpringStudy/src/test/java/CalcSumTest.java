import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import springbook.learningtest.template.Calculator;

import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CalcSumTest {
    private Calculator calculator;
    private String numFilePath;

    public static void main(String[] args) {
        JUnitCore.main("CalcSumTest");
    }

    @Before
    public void setUp() {
        this.calculator = new Calculator();
        this.numFilePath = getClass().getResource("numbers.txt").getPath();
    }

    @Test
    public void sumOfNumbers() throws IOException {
        assertThat(calculator.calcSum(numFilePath), is(10));
    }

    @Test
    public void multiplyOfNumbers() throws IOException {
        assertThat(calculator.calcMultiply(numFilePath), is(24));
    }

    @Test
    public void concatenateStrings() throws IOException {
        assertThat(calculator.concatenate(numFilePath), is("1234"));
    }
}
