package com.calculatoria.step;

import com.calculatoria.pages.BasicCalcPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseCalcSteps {

    protected BasicCalcPage basicCalcPage;

    public BaseCalcSteps(WebDriver driver) {
        basicCalcPage = new BasicCalcPage(driver);
    }

    @Step
    public void enter2numbers1operation(String a, String b, String o) {
        basicCalcPage.clearInput();
        basicCalcPage.buttonPresser(a);
        basicCalcPage.buttonPresser(o);
        basicCalcPage.buttonPresser(b);
    }

    @Step
    public void pressEnter() {
        basicCalcPage.buttonPresser("=");
    }

    @Step
    public void checkResultOnScreen(String r){
        assertEquals(r, basicCalcPage.getScreenVal());
    }

    @Step
    public void checkRecordInNotes(String a, String b, String op, String sum) {
        assertEquals(a+op+b+"="+sum, basicCalcPage.getLastNotesVal());
    }

}