package com.calculatoria.step;

import com.calculatoria.pages.SciCalcPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class SciCalcSteps extends BaseCalcSteps {

    protected SciCalcPage sciCalcPage;

    public SciCalcSteps(WebDriver driver) {
        super(driver);
        sciCalcPage = new SciCalcPage(driver);
    }

    @Step
    public void getSqrtOneVal(String a) {
        sciCalcPage.clearInput();
        sciCalcPage.digitPresser(a);
        sciCalcPage.pressSqrt();
    }

    @Step
    public void getPowerTwoVal(String a, String b) {
        sciCalcPage.clearInput();
        sciCalcPage.digitPresser(a);
        sciCalcPage.pressPwr();
        sciCalcPage.digitPresser(b);
    }
}
