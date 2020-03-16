package com.calculatoria.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.calculatoria.pages.Util.clickScript;

public class SciCalcPage extends BasicCalcPage {

    private static final String pageUrl = "/scientific-online-calculator";

    @FindBy(xpath = "//a[@title='Square root of x']")
    protected WebElement sqrootCtrl;

    @FindBy(xpath = "//a[@title='x raised to the power of y']")
    protected WebElement powerCtrl;

    public SciCalcPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl + pageUrl);
        PageFactory.initElements(driver, this);
    }

    public void pressSqrt() {
        executor.executeScript(clickScript, sqrootCtrl);
    }

    public void pressPwr() {
        jsClicker(powerCtrl);
    }
}
