package com.calculatoria.step;

import com.calculatoria.pages.BasicCalcPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import java.io.UnsupportedEncodingException;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseCalcSteps {

    protected BasicCalcPage basicCalcPage;

    public BaseCalcSteps(WebDriver driver) {
        basicCalcPage = new BasicCalcPage(driver);
    }

    @Step
    public void operationWithTwoValues(String a, String b, Character op) {
        basicCalcPage.clearInput();
        basicCalcPage.digitPresser(a);
        switch (op) {
            case '+':
                basicCalcPage.pressSum();
                break;
            case '-':
                basicCalcPage.pressSub();
                break;
            case '*':
                basicCalcPage.pressMult();
                break;
            case '/':
                basicCalcPage.pressDiv();
                break;
            default:
                System.out.println("Unknown parameter in test data");
        }

        basicCalcPage.digitPresser(b);
    }

    @Step
    public void pressEnter() {
        basicCalcPage.pressEquals();
    }

    @Step
    public void checkResultOnScreen(String r){
        assertEquals(r, basicCalcPage.getScreenVal());
    }

    @Step
    public void checkRecordInNotes(String a, String b, String op, String sum) throws UnsupportedEncodingException {
        assertEquals(a+op+b+"="+sum, basicCalcPage.getLastNotesVal());
    }

    @Step
    public void checkRecordInNotes(String a, String op, String b) throws UnsupportedEncodingException {
        assertEquals(op+" "+a+"="+b, basicCalcPage.getLastNotesVal());
    }

}