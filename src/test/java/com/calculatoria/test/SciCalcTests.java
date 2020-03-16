package com.calculatoria.test;


import com.calculatoria.step.SciCalcSteps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.UnsupportedEncodingException;


public class SciCalcTests extends BaseTest {

    protected static SciCalcSteps sciCalcSteps;

    public SciCalcTests(){
        sciCalcSteps = new SciCalcSteps(driver);
    }

    @ParameterizedTest(name = "{index} > a={0}, sqrt={1}")
    @MethodSource("com.calculatoria.testdata.TestData#sqrtTestDataProvider")
    @Description("test square root of 1 numbers")
    @DisplayName( "Test Square root operation sqrt(a)")
    public void testSqrt(String a, String b) throws UnsupportedEncodingException {
        sciCalcSteps.getSqrtOneVal(a);
        sciCalcSteps.checkResultOnScreen(b);    //Two separate checkpoints each test
        sciCalcSteps.checkRecordInNotes(a, "&radic;", b);
    }

    @ParameterizedTest(name = "{index} > a={0}, pow={1}, equals={2}")
    @MethodSource("com.calculatoria.testdata.TestData#powTestDataProvider")
    @Description("test a power b")
    @DisplayName( "Test one value Power second value")
    public void testPower(String a, String b, String res) throws UnsupportedEncodingException {
        sciCalcSteps.getPowerTwoVal(a, b);
        sciCalcSteps.pressEnter();
        sciCalcSteps.checkResultOnScreen(res);
        sciCalcSteps.checkRecordInNotes(a, b, "^", res);
    }

}
