package com.calculatoria.test;

import com.calculatoria.step.BaseCalcSteps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.UnsupportedEncodingException;


public class BasicCalcTests extends BaseTest {

    protected static BaseCalcSteps baseCalcSteps;

    public BasicCalcTests(){
        baseCalcSteps = new BaseCalcSteps(driver);
    }

    @ParameterizedTest(name = "{index} > a={0}, b={1}, sum={2}")
    @MethodSource("com.calculatoria.testdata.TestData#additionTestDataProvider")
    @Description("test addition of 2 numbers")
    @DisplayName( "Test Add operation a + b")
    public void testAdd(String a, String b, String sum) throws UnsupportedEncodingException {
        baseCalcSteps.operationWithTwoValues(a, b, '+');
        baseCalcSteps.pressEnter();
        baseCalcSteps.checkResultOnScreen(sum);
        baseCalcSteps.checkRecordInNotes(a, b, "+", sum);
    }

    @ParameterizedTest(name = "{index} > a={0}, b={1}, sub={2}")
    @MethodSource("com.calculatoria.testdata.TestData#subtractionTestDataProvider")
    @Description("test subtraction of 2 numbers")
    @DisplayName( "Test Subtract operation a - b")
    public void testSubtract(String a, String b, String sub) throws UnsupportedEncodingException {
        baseCalcSteps.operationWithTwoValues(a, b, '-');
        baseCalcSteps.pressEnter();
        baseCalcSteps.checkResultOnScreen(sub);
        baseCalcSteps.checkRecordInNotes(a, b, "-", sub);
    }

    @ParameterizedTest(name = "{index} > a={0}, b={1}, mult={2}")
    @MethodSource("com.calculatoria.testdata.TestData#multiplicationTestDataProvider")
    @Description("test multiplication of 2 numbers")
    @DisplayName( "Test Multiply operation a x b")
    public void testMultiply(String a, String b, String mult) throws UnsupportedEncodingException {
        baseCalcSteps.operationWithTwoValues(a, b, '*');
        baseCalcSteps.pressEnter();
        baseCalcSteps.checkResultOnScreen(mult);
        baseCalcSteps.checkRecordInNotes(a, b, "*", mult);
    }

    @ParameterizedTest(name = "{index} > a={0}, b={1}, div={2}")
    @MethodSource("com.calculatoria.testdata.TestData#divisionTestDataProvider")
    @Description("test division of 2 numbers")
    @DisplayName( "Test Divide operation a / b")
    public void testDivision(String a, String b, String div) throws UnsupportedEncodingException {
        baseCalcSteps.operationWithTwoValues(a, b, '/');
        baseCalcSteps.pressEnter();
        baseCalcSteps.checkResultOnScreen(div);
        baseCalcSteps.checkRecordInNotes(a, b, "/", div);
    }

}